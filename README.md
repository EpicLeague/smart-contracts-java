# Smart Contracts - Java

## Web3j generation command
```web3j generate truffle --truffle-json=<json_path> -o .\generated-java -p contracts.<sub_packagename>``` 

## For smart-contract project

```
web3j generate truffle --truffle-json=.\artifacts\contracts\nft\v2\Memento.sol\Memento.json -o .\generated-java -p contracts.nft.v2
web3j generate truffle --truffle-json=.\artifacts\contracts\nft\v2\MysteryBoxOpener.sol\MysteryBoxOpener.json -o .\generated-java -p contracts.nft.v2
web3j generate truffle --truffle-json=.\artifacts\contracts\nft\v2\MysteryBox.sol\MysteryBox.json -o .\generated-java -p contracts.nft.v2
```

### For epl-contract project
```
web3j generate truffle -o .\generated-java -p contracts.tokenomics --truffle-json=.\build\contracts\EpicLeague.json 
web3j generate truffle -o .\generated-java -p contracts.tokenomics --truffle-json=.\build\contracts\Treasury.json 
web3j generate truffle -o .\generated-java -p contracts.tokenomics --truffle-json=.\build\contracts\TreasuryVestingWallet.json 
web3j generate truffle -o .\generated-java -p contracts.nft.v1 --truffle-json=.\build\contracts\TotemRental.json 
web3j generate truffle -o .\generated-java -p contracts.nft.v1 --truffle-json=.\build\contracts\Totem.json 
web3j generate truffle -o .\generated-java -p contracts.nft.v1 --truffle-json=.\build\contracts\TotemBoxAirdrop.json
web3j generate truffle -o .\generated-java -p contracts.nft.v1 --truffle-json=.\build\contracts\TotemBoxFlashSale.json
web3j generate truffle -o .\generated-java -p contracts.nft.v1 --truffle-json=.\build\contracts\TotemBoxHubV1.json
web3j generate truffle -o .\generated-java -p contracts.nft.v1 --truffle-json=.\build\contracts\TotemBoxLaunchpad.json
web3j generate truffle -o .\generated-java -p contracts.nft.v1 --truffle-json=.\build\contracts\TotemBoxOpener.json
web3j generate truffle -o .\generated-java -p contracts.nft.v1 --truffle-json=.\build\contracts\TotemBoxWhitelist.json
web3j generate truffle -o .\generated-java -p contracts.tokenomics --truffle-json=.\build\contracts\DepositEPL.json
```