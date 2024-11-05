package constants;

import java.util.List;
import java.util.Map;

public class ContractAddressHolder {

    private static final Map<ContractAlias, Map<NetworkId, List<String>>> contractAddressMap = Map.of(
            ContractAlias.treasury, Map.of(
                    NetworkId.BNB_TESTNET, List.of("0x1bb82815A847549feB26170825c70Ae63850d117"),
                    NetworkId.HMV_TESTNET, List.of("0x578dd0Fe6c365421A429c5f3DD8668189Ea6206e"),
                    NetworkId.BNB_MAINNET, List.of("0xaEa3C8a57Db62402bdE5A76ec504c2c4497Afa64"),
                    NetworkId.POLYGON_MAINNET, List.of("0x32E8E7Eaa7319137221158a9D99Ec1596AB45131"),
                    NetworkId.ETH_MAINNET, List.of("0x647aae7b6b1c46de037111657a50297da34fc359"),
                    NetworkId.HMV_MAINNET, List.of("0x533b75295dafb91AdDaca442c1c83dF1d8819D39")
            ));

    public static String getContractAddress(ContractAlias contractAlias, NetworkId networkId) {
        if(!contractAddressMap.containsKey(contractAlias)) {
            throw new IllegalArgumentException("Contract alias not found: " + contractAlias);
        }
        if(!contractAddressMap.get(contractAlias).containsKey(networkId)) {
            throw new IllegalArgumentException("Network id not found: " + networkId);
        }

        return contractAddressMap.get(contractAlias).get(networkId).getFirst();
    }
}
