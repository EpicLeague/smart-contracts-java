package constants;

import contracts.nft.v1.*;
import contracts.nft.v2.Memento;
import contracts.nft.v2.MysteryBox;
import contracts.nft.v2.MysteryBoxOpener;
import contracts.tokenomics.DepositEPL;
import contracts.tokenomics.EpicLeague;
import contracts.tokenomics.Treasury;
import contracts.tokenomics.TreasuryVestingWallet;
import org.web3j.tx.Contract;

/**
 * deposit_epl
 * epl
 * memento
 * mysterybox
 * mysterybox_opener
 * totem
 * totembox
 * totembox_opener
 * totem_rental
 * treasury
 * treasury_vesting
 */
public enum ContractAlias {
    deposit_epl(DepositEPL.class),
    epl(EpicLeague.class),
    memento(Memento.class),
    mysterybox(MysteryBox.class),
    mysterybox_opener(MysteryBoxOpener.class),
    totem(Totem.class),
    totembox(TotemBoxHubV1.class),
    totembox_opener(TotemBoxOpener.class),
    totem_rental(TotemRental.class),
    treasury(Treasury.class),
    treasury_vesting(TreasuryVestingWallet.class);

    private final Class<? extends Contract> contractClass;

    ContractAlias(Class<? extends Contract> contractClass) {
        this.contractClass = contractClass;
    }

    public Class<? extends Contract> getContractClass() {
        return contractClass;
    }
}
