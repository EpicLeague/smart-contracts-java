package constants;

import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class ContractAddressHolder {

    private static final Map<ContractAlias, Map<NetworkId, List<String>>> contractAddressMap = Map.ofEntries(
            entry(ContractAlias.treasury, Map.of(
                    NetworkId.BNB_TESTNET, List.of("0x1bb82815A847549feB26170825c70Ae63850d117"),
                    NetworkId.HMV_TESTNET, List.of("0x578dd0Fe6c365421A429c5f3DD8668189Ea6206e"),
                    NetworkId.BNB_MAINNET, List.of("0xaEa3C8a57Db62402bdE5A76ec504c2c4497Afa64"),
                    NetworkId.POLYGON_MAINNET, List.of("0x32E8E7Eaa7319137221158a9D99Ec1596AB45131"),
                    NetworkId.ETH_MAINNET, List.of("0x647aae7b6b1c46de037111657a50297da34fc359"),
                    NetworkId.HMV_MAINNET, List.of("0x533b75295dafb91AdDaca442c1c83dF1d8819D39")
            )),
//            entry(ContractAlias.epl, Map.of(
//                    NetworkId.BNB_TESTNET, List.of("0x0851d9fd9339f5a06c5646df939bb6ae4aa36b46"),
//                    NetworkId.HMV_TESTNET, List.of("0x33FFcD33Baa26D0Aa2f359Edc883cA8626d05b6e"),
//                    NetworkId.BNB_MAINNET, List.of("0x1236ea13c7339287Cd00AB196aAA8217006b04dc"),
//                    NetworkId.POLYGON_MAINNET, List.of("0x1236ea13c7339287Cd00AB196aAA8217006b04dc"),
//                    NetworkId.ETH_MAINNET, List.of("0x1236ea13c7339287Cd00AB196aAA8217006b04dc"),
//                    NetworkId.HMV_MAINNET, List.of("0x9e1028F5F1D5eDE59748FFceE5532509976840E0")
//            )),
            entry(ContractAlias.deposit_epl, Map.of(
                    NetworkId.BNB_TESTNET, List.of("0xa259c9f11561d8459c870a3bd7e402be2c83ab5b"),
                    NetworkId.HMV_TESTNET, List.of("0x59ddd709c7a38fe31a3920B7740cf6D12F7135f2"),
                    NetworkId.BNB_MAINNET, List.of("0x8d88d387Ff9C0BdE4707fef772Ac13f6544a0D3F"),
                    NetworkId.POLYGON_MAINNET, List.of("0x0d4c9F69E29b9F17a07eE661654D456217F76e15"),
                    NetworkId.HMV_MAINNET, List.of("0x923a336953f625329d4E746038be0dea71BaFC9e")
            )),
            entry(ContractAlias.memento, Map.of(
                    NetworkId.POLYGON_TESTNET_AMOY, List.of("0xE0f98D0967F93BF54f9F6ef27685bFD82629Bc7E"),
                    NetworkId.BNB_MAINNET, List.of("0xfd41A086BD119431E23ee8884d783edf68dcb2c8"),
                    NetworkId.POLYGON_MAINNET, List.of("0x4F9D47211eA7eD2A7dd9416bA91bf99b56300B31")
            )),
            entry(ContractAlias.mysterybox, Map.of(
                    NetworkId.BNB_MAINNET, List.of("0x59351bE7aFa41540A30A4673D5703Af2Ca63b374"),
                    NetworkId.POLYGON_MAINNET, List.of("0x7D1415d75336962A015f9753cba876D7d89671d9"),
                    NetworkId.POLYGON_TESTNET_AMOY, List.of("0xb56F7bf58A1B4073B252daD75ab1311a756EaAdc")
            )),
            entry(ContractAlias.mysterybox_opener, Map.of(
                    NetworkId.BNB_MAINNET, List.of("0x447024aBEe8727a2DC6ba3748a6534B80405CCC8"),
                    NetworkId.POLYGON_MAINNET, List.of("0x0Ad2ca498627A52a69560a08646A7D4c270Cf53d"),
                    NetworkId.POLYGON_TESTNET_AMOY, List.of("0xdF9E7089B9404F5A5E4a891C5F2D364524E0F1E1")
            )),
            entry(ContractAlias.totem, Map.of(
                    NetworkId.BNB_TESTNET, List.of("0xd2045294Cc73Ff977dbf3C6EeA4C0FCFaE52feCe"),
                    NetworkId.HMV_TESTNET, List.of("0x78C186d9Cc9a03d5C5650950c99f17a099Be1299"),
                    NetworkId.BNB_MAINNET, List.of("0x6816DCd5920ca38168BEF1A72CF1f240918D90de"),
                    NetworkId.POLYGON_MAINNET, List.of("0xEb1b870ef34b5b6960E2857F9283A6e99175CBf7"),
                    NetworkId.HMV_MAINNET, List.of("0x7B5d13eaA019736d002D2271df239Ef698611f83")
            )),
            entry(ContractAlias.totembox, Map.of(
                    NetworkId.BNB_TESTNET, List.of("0x1d81D1C07b0A02d8085AE56619DD60d21E50C794",
                            "0x6Df56B6410600BDb2D27b2Fe72624DB2413aF7c6",
                            "0x90e9b1b285EbfC9CB20D8BD33a9CeB2b12615b12", "0xF8b48d2b16b3bd8beccD99Cf5474B9e9F928EF54"),
                    NetworkId.HMV_TESTNET, List.of("0x02ad1cE99fa35F88500e67D5b8d98da025df8e5e"),
                    NetworkId.BNB_MAINNET, List.of(
                            "0x65b448f6d1a47be83e608109506ae5185735e832",
                            "0x7B5d13eaA019736d002D2271df239Ef698611f83",
                            "0x9079001beA33b42d1D74bD9F34096D81AFe94a02",
                            "0x923a336953f625329d4E746038be0dea71BaFC9e"
                    ),
                    NetworkId.POLYGON_MAINNET, List.of("0x7162C8A6f9a43ff152Cd326F03A83BF0992D8414", "0xF61c47ae5946a94De205BcdCE85cc9429640eb29"),
                    NetworkId.HMV_MAINNET, List.of("0x253B1cD710EB2BFc4A1839b1710e8145F9Cb60EF", "0x4bb35A18c570c864F8c8f53c051e039443429079")
            )),
            entry(ContractAlias.totembox_opener, Map.of(
                    NetworkId.BNB_TESTNET, List.of("0xdEafeB5b7B637Dd91b17A25a30997C053994bA41"),
                    NetworkId.HMV_TESTNET, List.of("0x952463EB27DDFE677943C7773962366eA5c79708"),
                    NetworkId.BNB_MAINNET, List.of("0x96abc20c1f6f51a071cdd87054926ef2b681864a"),
                    NetworkId.POLYGON_MAINNET, List.of("0x647Aae7B6b1C46De037111657A50297da34FC359"),
                    NetworkId.HMV_MAINNET, List.of("0xEb1b870ef34b5b6960E2857F9283A6e99175CBf7")
            )),
            entry(ContractAlias.totem_rental, Map.of(
                    NetworkId.BNB_TESTNET, List.of("0x98d91bB259DF8889b51fa703d73743eF36c81aD1"),
                    NetworkId.HMV_TESTNET, List.of("0x5EA92Fe836DdEfd4F5A6dB6D2012b3F1C1c3dD6F"),
                    NetworkId.BNB_MAINNET, List.of("0x055695bE82229dA0d2e8fA17A78AC1a1170251E1"),
                    NetworkId.POLYGON_MAINNET, List.of("0x940648c77E1a282e5D814869c6c301598777E5CC"),
                    NetworkId.HMV_MAINNET, List.of("0x496ceE13203d22A060D5E0b97F75E5C39E556ee4")
            )),
            entry(ContractAlias.treasury_vesting, Map.of(
                    NetworkId.BNB_TESTNET, List.of("0x78c19247bD1414306711F3C068D66d392fD52CA3"),
                    NetworkId.BNB_MAINNET, List.of("0xA682B1804d3e77625eD469C6839651bB9D452610"),
                    NetworkId.POLYGON_MAINNET, List.of("0x6455063143e5D126e67FB8fF3b22bB01c1834ee8"),
                    NetworkId.HMV_MAINNET, List.of("0xC297E5685de0f815e587122FA8389A24b225205f")
            ))
    );

    public static String getContractAddress(ContractAlias contractAlias, NetworkId networkId) {
        if (!contractAddressMap.containsKey(contractAlias)) {
            throw new IllegalArgumentException("Contract alias not found: " + contractAlias);
        }
        if (!contractAddressMap.get(contractAlias).containsKey(networkId)) {
            throw new IllegalArgumentException("Network id not found: " + networkId);
        }

        return contractAddressMap.get(contractAlias).get(networkId).getFirst();
    }
}
