package constants;

import contracts.nft.v1.Totem;
import contracts.nft.v1.TotemBoxHubV1;
import contracts.nft.v1.TotemBoxOpener;
import contracts.nft.v2.Memento;
import contracts.nft.v2.MysteryBox;
import contracts.nft.v2.MysteryBoxOpener;
import contracts.tokenomics.DepositEPL;
import contracts.tokenomics.Treasury;
import contracts.tokenomics.TreasuryVestingWallet;

import org.web3j.protocol.Web3j;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;


import java.lang.reflect.Method;
import java.util.Map;

public class ContractHolder {

    private static final Map<ContractAlias, Class<? extends Contract>> contractMap = Map.of(
            ContractAlias.treasury, Treasury.class,
//            ContractAlias.epl, ,
            ContractAlias.deposit_epl, DepositEPL.class,
            ContractAlias.memento, Memento.class,
            ContractAlias.mysterybox, MysteryBox.class,
            ContractAlias.mysterybox_opener, MysteryBoxOpener.class,
            ContractAlias.totem, Totem.class,
            ContractAlias.totembox, TotemBoxHubV1.class,
            ContractAlias.totembox_opener, TotemBoxOpener.class,
            ContractAlias.treasury_vesting, TreasuryVestingWallet.class
    );

    @SuppressWarnings("unchecked")
    public static <T extends Contract> T loadContract(ContractAlias alias, String contractAddress, Web3j web3j,
                                                      TransactionManager txManager, ContractGasProvider gasProvider) {
        // Get the contract class directly from the alias
        Class<T> contractClass = (Class<T>) alias.getContractClass();
        if (contractClass == null) {
            throw new IllegalArgumentException("No contract class mapped for alias: " + alias);
        }

        try {
            // Use reflection to find the static "load" method
            Method loadMethod = contractClass.getMethod("load", String.class, Web3j.class, TransactionManager.class, ContractGasProvider.class);
            // Invoke the "load" method with provided arguments
            return (T) loadMethod.invoke(null, contractAddress, web3j, txManager, gasProvider);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load contract for alias: " + alias, e);
        }
    }
}
