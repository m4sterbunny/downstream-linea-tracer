/*
 * Copyright Consensys Software Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package net.consensys.linea.zktracer.runtime.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.consensys.linea.zktracer.module.hub.Hub;
import net.consensys.linea.zktracer.opcode.OpCode;
import net.consensys.linea.zktracer.runtime.callstack.CallFrame;
import net.consensys.linea.zktracer.types.MemorySegmentSnapshot;
import net.consensys.linea.zktracer.types.UnsignedByte;

/**
 * A StackContext encode the stack-related information pertaining to the execution of an opcode
 * within a {@link CallFrame}. These cached information are used by the {@link Hub} to generate its
 * traces in the stack perspective.
 */
@Accessors(fluent = true)
public final class StackContext {
  @Getter @Setter MemorySegmentSnapshot memorySegmentSnapshot;

  /** The opcode that triggered the stack operations. */
  OpCode opCode;

  /** One or two lines to be traced, representing the stack operations performed by the opcode. */
  @Getter final List<StackLine> lines = new ArrayList<>(4);

  /**
   * The default constructor for a valid, albeit empty line.
   *
   * @param opCode the {@link OpCode} triggering the lines creation
   */
  public StackContext(OpCode opCode) {
    this.opCode = opCode;
    this.memorySegmentSnapshot = new MemorySegmentSnapshot(UnsignedByte.EMPTY_BYTES16);
  }

  /**
   * Generate a given number of empty stack lines; typically used as valid padding in the case of
   * stack exception.
   *
   * @param k the number of empty lines to generate
   * @return the number of empty lines generated
   */
  int addEmptyLines(int k) {
    for (int i = 0; i < k; i++) {
      this.lines.add(new StackLine());
    }
    return k;
  }

  /**
   * Creates a new stack lint that will not require unlatching, either because no value are pushed
   * or because they are already known.
   *
   * @param items the stack operations to execute
   */
  void addLine(IndexedStackOperation... items) {
    int newPos = this.lines.size();
    this.lines.add(new StackLine(newPos, items));
  }

  /**
   * Creates a new stack line that will require unlatching.
   *
   * @param posResult in which stack item the result shall be unlatched
   * @param items the stack operations to execute
   */
  void addArmingLine(int posResult, IndexedStackOperation... items) {
    this.lines.add(new StackLine(Arrays.stream(items).toList(), posResult));
  }

  /**
   * As virtually all latched stack operations write to item #4, this provides a shortcut for it.
   *
   * @param items the stack operations to execute
   */
  void addArmingLine(IndexedStackOperation... items) {
    this.addArmingLine(4, items);
  }
}
