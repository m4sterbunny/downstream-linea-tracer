# Linea arithmetization (zkEVM)

This repository hosts a Linea tracing implementation for 
[Hyperledger Besu](https://github.com/hyperledger/besu) based on an 
[existing implementation in Go](https://github.com/Consensys/zk-evm/).

It serves developers by making the Linea tech stack open source under 
the [Apache 2.0 license](https://github.com/Consensys/linea-monorepo/blob/main/LICENSE).

## What is Linea?

[Linea](https://linea.build) is a developer-ready layer 2 network scaling Ethereum. It's secured with a zero-knowledge rollup, built on lattice-based cryptography, and powered by [Consensys](https://consensys.io).

## Get started

If you already have an understanding of the tech stack, use our [Get Started](docs/get-started.md) guide.

## Looking for the Linea code?

### Plugins

Discover [existing plugins](docs/plugins.md) and understand the [plugin release process](docs/plugin-release.md). 

### Tech stack

Linea's stack is made up of multiple repositories, these include:

- [linea-monorepo](https://github.com/Consensys/linea-monorepo): The main repository for the Linea stack & network 
- [linea-besu](https://github.com/Consensys/linea-besu): Fork of Besu to implement the Linea-Besu client
- [linea-sequencer](https://github.com/Consensys/linea-sequencer): A set of Linea-Besu plugins for the sequencer and RPC nodes
- [linea-arithmetization](https://github.com/Consensys/linea-arithmetization): Linea-Besu plugins to implement the constraints for the circuits used to construct the zero-knowledge proofs
- [linea-constraints](https://github.com/Consensys/linea-constraints): Constraints applied to the arithmetization, and ultimately to the circuits
- Coming soon: [linea-specification](https://github.com/Consensys/linea-specification): Home of the zk-EVM specification

Linea abstracts away the complexity of this technical architecture to allow developers to:

- [Bridge tokens](https://docs.linea.build/developers/guides/bridge)
- [Deploy a contract](https://docs.linea.build/developers/quickstart/deploy-smart-contract)
- [Run a node](https://docs.linea.build/developers/guides/run-a-node)

... and more.

## How to contribute

Contributions of any kind are welcome!

1. [Create an issue](https://github.com/Consensys/linea-monorepo/issues)
> If the proposed update is non-trivial, also tag us for discussion.
2. Submit the update as a pull request from your [fork of this repo](https://github.com/Consensys/linea-monorepo/fork), and tag us for review. 
> Include the issue number in the pull request description and (optionally) in the branch name.

Consider starting with a ["good first issue"](https://github.com/ConsenSys/linea-monorepo/issues?q=is%3Aissue+is%3Aopen+label%3A%22good+first+issue%22).

Before contributing, ensure you're familiar with:

- Our [contribution guide](https://github.com/Consensys/linea-monorepo/blob/main/docs/contribute.md)
- Our [code of conduct](https://github.com/Consensys/linea-monorepo/blob/main/docs/code-of-conduct.md)
- The [Besu contribution guide](https://github.com/Consensys/linea-monorepo/blob/main/https://wiki.hyperledger.org/display/BESU/Coding+Conventions), for Besu:Linea related contributions


### Useful links

[Reach out, or learn more](https://github.com/Consensys/linea-monorepo/blob/main/readme.md#useful-links).