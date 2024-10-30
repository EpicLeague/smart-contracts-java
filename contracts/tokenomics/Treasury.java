package contracts.tokenomics;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/hyperledger/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.6.1.
 */
@SuppressWarnings("rawtypes")
public class Treasury extends Contract {
    public static final String BINARY = "0x60a0604052306080523480156200001557600080fd5b506200002062000026565b62000156565b6200003260ff62000035565b50565b60008054610100900460ff1615620000ce578160ff1660011480156200006e57506200006c306200014760201b62000b931760201c565b155b620000c65760405162461bcd60e51b815260206004820152602e602482015260008051602062001b8783398151915260448201526d191e481a5b9a5d1a585b1a5e995960921b60648201526084015b60405180910390fd5b506000919050565b60005460ff8084169116106200012d5760405162461bcd60e51b815260206004820152602e602482015260008051602062001b8783398151915260448201526d191e481a5b9a5d1a585b1a5e995960921b6064820152608401620000bd565b506000805460ff191660ff92909216919091179055600190565b6001600160a01b03163b151590565b6080516119f96200018e600039600081816104b7015281816104f7015281816105b6015281816105f6015261068501526119f96000f3fe60806040526004361061011f5760003560e01c80635c975abb116100a0578063d547741f11610064578063d547741f14610313578063e63ab1e914610333578063f0f80ace14610355578063f3fef3a314610375578063f72c0d8b1461039557600080fd5b80635c975abb146102915780638456cb59146102a957806391d14854146102be578063a217fddf146102de578063c4d66de8146102f357600080fd5b80633659cfe6116100e75780633659cfe6146101fb5780633f4ba83a1461021b5780634ae56a96146102305780634f1ef2861461026957806352d1902d1461027c57600080fd5b806301ffc9a714610124578063206b60f914610159578063248a9ca3146101895780632f2ff15d146101b957806336568abe146101db575b600080fd5b34801561013057600080fd5b5061014461013f366004611466565b6103c9565b60405190151581526020015b60405180910390f35b34801561016557600080fd5b5061017b60008051602061193d83398151915281565b604051908152602001610150565b34801561019557600080fd5b5061017b6101a4366004611490565b60009081526097602052604090206001015490565b3480156101c557600080fd5b506101d96101d43660046114c0565b610400565b005b3480156101e757600080fd5b506101d96101f63660046114c0565b61042a565b34801561020757600080fd5b506101d96102163660046114ec565b6104ad565b34801561022757600080fd5b506101d961058c565b34801561023c57600080fd5b5061012d54610251906001600160a01b031681565b6040516001600160a01b039091168152602001610150565b6101d961027736600461151d565b6105ac565b34801561028857600080fd5b5061017b610678565b34801561029d57600080fd5b5060335460ff16610144565b3480156102b557600080fd5b506101d961072b565b3480156102ca57600080fd5b506101446102d93660046114c0565b61074b565b3480156102ea57600080fd5b5061017b600081565b3480156102ff57600080fd5b506101d961030e3660046114ec565b610776565b34801561031f57600080fd5b506101d961032e3660046114c0565b61088f565b34801561033f57600080fd5b5061017b60008051602061197d83398151915281565b34801561036157600080fd5b506101d96103703660046115df565b6108b4565b34801561038157600080fd5b506101d9610390366004611612565b610a90565b3480156103a157600080fd5b5061017b7f189ab7a9244df0848122154315af71fe140f3db0fe014031783b0946b8c9d2e381565b60006001600160e01b03198216637965db0b60e01b14806103fa57506301ffc9a760e01b6001600160e01b03198316145b92915050565b60008281526097602052604090206001015461041b81610ba2565b6104258383610bac565b505050565b6001600160a01b038116331461049f5760405162461bcd60e51b815260206004820152602f60248201527f416363657373436f6e74726f6c3a2063616e206f6e6c792072656e6f756e636560448201526e103937b632b9903337b91039b2b63360891b60648201526084015b60405180910390fd5b6104a98282610c32565b5050565b6001600160a01b037f00000000000000000000000000000000000000000000000000000000000000001630036104f55760405162461bcd60e51b81526004016104969061163c565b7f00000000000000000000000000000000000000000000000000000000000000006001600160a01b031661053e60008051602061195d833981519152546001600160a01b031690565b6001600160a01b0316146105645760405162461bcd60e51b815260040161049690611688565b61056d81610c99565b6040805160008082526020820190925261058991839190610cc3565b50565b60008051602061197d8339815191526105a481610ba2565b610589610e2e565b6001600160a01b037f00000000000000000000000000000000000000000000000000000000000000001630036105f45760405162461bcd60e51b81526004016104969061163c565b7f00000000000000000000000000000000000000000000000000000000000000006001600160a01b031661063d60008051602061195d833981519152546001600160a01b031690565b6001600160a01b0316146106635760405162461bcd60e51b815260040161049690611688565b61066c82610c99565b6104a982826001610cc3565b6000306001600160a01b037f000000000000000000000000000000000000000000000000000000000000000016146107185760405162461bcd60e51b815260206004820152603860248201527f555550535570677261646561626c653a206d757374206e6f742062652063616c60448201527f6c6564207468726f7567682064656c656761746563616c6c00000000000000006064820152608401610496565b5060008051602061195d83398151915290565b60008051602061197d83398151915261074381610ba2565b610589610ec1565b60009182526097602090815260408084206001600160a01b0393909316845291905290205460ff1690565b60006107826001610f19565b9050801561079a576000805461ff0019166101001790555b6001600160a01b0382166107ad57600080fd5b6107b5610fa6565b6107bd610fd7565b6107c5610fd7565b6107d0600033610bac565b6107e860008051602061197d83398151915233610bac565b6108127f189ab7a9244df0848122154315af71fe140f3db0fe014031783b0946b8c9d2e333610bac565b61082a60008051602061193d83398151915233610bac565b61012d80546001600160a01b0319166001600160a01b03841617905580156104a9576000805461ff0019169055604051600181527f7f26b83ff96e1f2b6a682f133852f6798a09c465da95921460cefb38474024989060200160405180910390a15050565b6000828152609760205260409020600101546108aa81610ba2565b6104258383610c32565b60008051602061193d8339815191526108cc81610ba2565b60335460ff16156108ef5760405162461bcd60e51b8152600401610496906116d4565b61012d546040516370a0823160e01b815230600482015284916001600160a01b0316906370a0823190602401602060405180830381865afa158015610938573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061095c91906116fe565b10610a385761012d5460405163a9059cbb60e01b81526001600160a01b038681166004830152602482018690529091169063a9059cbb906044016020604051808303816000875af11580156109b5573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906109d99190611717565b6109e257600080fd5b604080516001600160a01b038616815260208101859052908101839052600160608201527f66d3feb93e8376e9663cd3fcad02bcc33cb7f23e698ab17839ff19073f60d7e19060800160405180910390a1610a8a565b604080516001600160a01b038616815260208101859052908101839052600060608201527f66d3feb93e8376e9663cd3fcad02bcc33cb7f23e698ab17839ff19073f60d7e19060800160405180910390a15b50505050565b60008051602061193d833981519152610aa881610ba2565b60335460ff1615610acb5760405162461bcd60e51b8152600401610496906116d4565b61012d5460405163a9059cbb60e01b81526001600160a01b038581166004830152602482018590529091169063a9059cbb906044016020604051808303816000875af1158015610b1f573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610b439190611717565b610b4c57600080fd5b604080516001600160a01b0385168152602081018490527f7fcf532c15f0a6db0bd6d0e038bea71d30d808c7d98cb3bf7268a95bf5081b65910160405180910390a1505050565b6001600160a01b03163b151590565b6105898133610ffe565b610bb6828261074b565b6104a95760008281526097602090815260408083206001600160a01b03851684529091529020805460ff19166001179055610bee3390565b6001600160a01b0316816001600160a01b0316837f2f8788117e7eff1d82e926ec794901d17c78024a50270940304540a733656f0d60405160405180910390a45050565b610c3c828261074b565b156104a95760008281526097602090815260408083206001600160a01b0385168085529252808320805460ff1916905551339285917ff6391f5c32d9c69d2a47ea670b442974b53935d1edc7fd64eb21e047a839171b9190a45050565b7f189ab7a9244df0848122154315af71fe140f3db0fe014031783b0946b8c9d2e36104a981610ba2565b7f4910fdfa16fed3260ed0e7147f7cc6da11a60208b5b9406d12a635614ffd91435460ff1615610cf65761042583611062565b826001600160a01b03166352d1902d6040518163ffffffff1660e01b8152600401602060405180830381865afa925050508015610d50575060408051601f3d908101601f19168201909252610d4d918101906116fe565b60015b610db35760405162461bcd60e51b815260206004820152602e60248201527f45524331393637557067726164653a206e657720696d706c656d656e7461746960448201526d6f6e206973206e6f74205555505360901b6064820152608401610496565b60008051602061195d8339815191528114610e225760405162461bcd60e51b815260206004820152602960248201527f45524331393637557067726164653a20756e737570706f727465642070726f786044820152681a58589b195555525160ba1b6064820152608401610496565b506104258383836110fe565b60335460ff16610e775760405162461bcd60e51b815260206004820152601460248201527314185d5cd8589b194e881b9bdd081c185d5cd95960621b6044820152606401610496565b6033805460ff191690557f5db9ee0a495bf2e6ff9c91a7834c1ba4fdd244a5e8aa4e537bd38aeae4b073aa335b6040516001600160a01b03909116815260200160405180910390a1565b60335460ff1615610ee45760405162461bcd60e51b8152600401610496906116d4565b6033805460ff191660011790557f62e78cea01bee320cd4e420270b5ea74000d11b0c9f74754ebdbfc544b05a258610ea43390565b60008054610100900460ff1615610f60578160ff166001148015610f3c5750303b155b610f585760405162461bcd60e51b815260040161049690611739565b506000919050565b60005460ff808416911610610f875760405162461bcd60e51b815260040161049690611739565b506000805460ff191660ff92909216919091179055600190565b919050565b600054610100900460ff16610fcd5760405162461bcd60e51b815260040161049690611787565b610fd5611123565b565b600054610100900460ff16610fd55760405162461bcd60e51b815260040161049690611787565b611008828261074b565b6104a957611020816001600160a01b03166014611156565b61102b836020611156565b60405160200161103c9291906117fe565b60408051601f198184030181529082905262461bcd60e51b825261049691600401611873565b6001600160a01b0381163b6110cf5760405162461bcd60e51b815260206004820152602d60248201527f455243313936373a206e657720696d706c656d656e746174696f6e206973206e60448201526c1bdd08184818dbdb9d1c9858dd609a1b6064820152608401610496565b60008051602061195d83398151915280546001600160a01b0319166001600160a01b0392909216919091179055565b611107836112f9565b6000825111806111145750805b1561042557610a8a8383611339565b600054610100900460ff1661114a5760405162461bcd60e51b815260040161049690611787565b6033805460ff19169055565b606060006111658360026118bc565b6111709060026118db565b67ffffffffffffffff81111561118857611188611507565b6040519080825280601f01601f1916602001820160405280156111b2576020820181803683370190505b509050600360fc1b816000815181106111cd576111cd6118f3565b60200101906001600160f81b031916908160001a905350600f60fb1b816001815181106111fc576111fc6118f3565b60200101906001600160f81b031916908160001a90535060006112208460026118bc565b61122b9060016118db565b90505b60018111156112a3576f181899199a1a9b1b9c1cb0b131b232b360811b85600f166010811061125f5761125f6118f3565b1a60f81b828281518110611275576112756118f3565b60200101906001600160f81b031916908160001a90535060049490941c9361129c81611909565b905061122e565b5083156112f25760405162461bcd60e51b815260206004820181905260248201527f537472696e67733a20686578206c656e67746820696e73756666696369656e746044820152606401610496565b9392505050565b61130281611062565b6040516001600160a01b038216907fbc7cd75a20ee27fd9adebab32041f755214dbc6bffa90cc0225b39da2e5c2d3b90600090a250565b60606001600160a01b0383163b6113a15760405162461bcd60e51b815260206004820152602660248201527f416464726573733a2064656c65676174652063616c6c20746f206e6f6e2d636f6044820152651b9d1c9858dd60d21b6064820152608401610496565b600080846001600160a01b0316846040516113bc9190611920565b600060405180830381855af49150503d80600081146113f7576040519150601f19603f3d011682016040523d82523d6000602084013e6113fc565b606091505b5091509150611424828260405180606001604052806027815260200161199d6027913961142d565b95945050505050565b6060831561143c5750816112f2565b82511561144c5782518084602001fd5b8160405162461bcd60e51b81526004016104969190611873565b60006020828403121561147857600080fd5b81356001600160e01b0319811681146112f257600080fd5b6000602082840312156114a257600080fd5b5035919050565b80356001600160a01b0381168114610fa157600080fd5b600080604083850312156114d357600080fd5b823591506114e3602084016114a9565b90509250929050565b6000602082840312156114fe57600080fd5b6112f2826114a9565b634e487b7160e01b600052604160045260246000fd5b6000806040838503121561153057600080fd5b611539836114a9565b9150602083013567ffffffffffffffff8082111561155657600080fd5b818501915085601f83011261156a57600080fd5b81358181111561157c5761157c611507565b604051601f8201601f19908116603f011681019083821181831017156115a4576115a4611507565b816040528281528860208487010111156115bd57600080fd5b8260208601602083013760006020848301015280955050505050509250929050565b6000806000606084860312156115f457600080fd5b6115fd846114a9565b95602085013595506040909401359392505050565b6000806040838503121561162557600080fd5b61162e836114a9565b946020939093013593505050565b6020808252602c908201527f46756e6374696f6e206d7573742062652063616c6c6564207468726f7567682060408201526b19195b1959d85d1958d85b1b60a21b606082015260800190565b6020808252602c908201527f46756e6374696f6e206d7573742062652063616c6c6564207468726f7567682060408201526b6163746976652070726f787960a01b606082015260800190565b60208082526010908201526f14185d5cd8589b194e881c185d5cd95960821b604082015260600190565b60006020828403121561171057600080fd5b5051919050565b60006020828403121561172957600080fd5b815180151581146112f257600080fd5b6020808252602e908201527f496e697469616c697a61626c653a20636f6e747261637420697320616c72656160408201526d191e481a5b9a5d1a585b1a5e995960921b606082015260800190565b6020808252602b908201527f496e697469616c697a61626c653a20636f6e7472616374206973206e6f74206960408201526a6e697469616c697a696e6760a81b606082015260800190565b60005b838110156117ed5781810151838201526020016117d5565b83811115610a8a5750506000910152565b7f416363657373436f6e74726f6c3a206163636f756e74200000000000000000008152600083516118368160178501602088016117d2565b7001034b99036b4b9b9b4b733903937b6329607d1b60179184019182015283516118678160288401602088016117d2565b01602801949350505050565b60208152600082518060208401526118928160408501602087016117d2565b601f01601f19169190910160400192915050565b634e487b7160e01b600052601160045260246000fd5b60008160001904831182151516156118d6576118d66118a6565b500290565b600082198211156118ee576118ee6118a6565b500190565b634e487b7160e01b600052603260045260246000fd5b600081611918576119186118a6565b506000190190565b600082516119328184602087016117d2565b919091019291505056fe8502233096d909befbda0999bb8ea2f3a6be3c138b9fbf003752a4c8bce86f6c360894a13ba1a3210667c828492db98dca3e2076cc3735a920a3ca505d382bbc65d7a28e3265b37a6474929f336521b332c1681b933f6cb9f3376673440d862a416464726573733a206c6f772d6c6576656c2064656c65676174652063616c6c206661696c6564a264697066735822122074e4e613ff2d6a237495398a52c336f6d4af81b28e1ff06731da5f9ba7c9476f64736f6c634300080e0033496e697469616c697a61626c653a20636f6e747261637420697320616c726561";

    private static String librariesLinkedBinary;

    public static final String FUNC_DEFAULT_ADMIN_ROLE = "DEFAULT_ADMIN_ROLE";

    public static final String FUNC_PAUSER_ROLE = "PAUSER_ROLE";

    public static final String FUNC_TRANSFER_ROLE = "TRANSFER_ROLE";

    public static final String FUNC_UPGRADER_ROLE = "UPGRADER_ROLE";

    public static final String FUNC__EPLTOKEN = "_eplToken";

    public static final String FUNC_GETROLEADMIN = "getRoleAdmin";

    public static final String FUNC_GRANTROLE = "grantRole";

    public static final String FUNC_HASROLE = "hasRole";

    public static final String FUNC_PAUSED = "paused";

    public static final String FUNC_PROXIABLEUUID = "proxiableUUID";

    public static final String FUNC_RENOUNCEROLE = "renounceRole";

    public static final String FUNC_REVOKEROLE = "revokeRole";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_UPGRADETO = "upgradeTo";

    public static final String FUNC_UPGRADETOANDCALL = "upgradeToAndCall";

    public static final String FUNC_INITIALIZE = "initialize";

    public static final String FUNC_PAUSE = "pause";

    public static final String FUNC_UNPAUSE = "unpause";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final String FUNC_WITHDRAWFROMOFFCHAIN = "withdrawFromOffchain";

    public static final Event ADMINCHANGED_EVENT = new Event("AdminChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event BEACONUPGRADED_EVENT = new Event("BeaconUpgraded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event INITIALIZED_EVENT = new Event("Initialized", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
    ;

    public static final Event PAUSED_EVENT = new Event("Paused", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event ROLEADMINCHANGED_EVENT = new Event("RoleAdminChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Bytes32>(true) {}, new TypeReference<Bytes32>(true) {}));
    ;

    public static final Event ROLEGRANTED_EVENT = new Event("RoleGranted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event ROLEREVOKED_EVENT = new Event("RoleRevoked", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event UNPAUSED_EVENT = new Event("Unpaused", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event UPGRADED_EVENT = new Event("Upgraded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event WITHDRAWAL_EVENT = new Event("Withdrawal", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event WITHDRAWALFROMOFFCHAIN_EVENT = new Event("WithdrawalFromOffchain", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("1677429376372", "0x780579F41e33F1C7340e3Db5ebD027690b5dBdB1");
        _addresses.put("1", "0x647aae7b6b1c46de037111657a50297da34fc359");
        _addresses.put("56", "0xaEa3C8a57Db62402bdE5A76ec504c2c4497Afa64");
        _addresses.put("80001", "0x44bc3281a5B6F22641E4cD1ab7CaDAef6A6F8466");
        _addresses.put("5", "0xc7D43E14329958a6B9933De2c5a486e7a061b315");
        _addresses.put("137", "0x32E8E7Eaa7319137221158a9D99Ec1596AB45131");
        _addresses.put("19011", "0x533b75295dafb91AdDaca442c1c83dF1d8819D39");
        _addresses.put("40875", "0x578dd0Fe6c365421A429c5f3DD8668189Ea6206e");
        _addresses.put("97", "0x1bb82815A847549feB26170825c70Ae63850d117");
    }

    @Deprecated
    protected Treasury(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Treasury(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Treasury(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Treasury(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<AdminChangedEventResponse> getAdminChangedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ADMINCHANGED_EVENT, transactionReceipt);
        ArrayList<AdminChangedEventResponse> responses = new ArrayList<AdminChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AdminChangedEventResponse typedResponse = new AdminChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousAdmin = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.newAdmin = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static AdminChangedEventResponse getAdminChangedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(ADMINCHANGED_EVENT, log);
        AdminChangedEventResponse typedResponse = new AdminChangedEventResponse();
        typedResponse.log = log;
        typedResponse.previousAdmin = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.newAdmin = (String) eventValues.getNonIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<AdminChangedEventResponse> adminChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getAdminChangedEventFromLog(log));
    }

    public Flowable<AdminChangedEventResponse> adminChangedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADMINCHANGED_EVENT));
        return adminChangedEventFlowable(filter);
    }

    public static List<BeaconUpgradedEventResponse> getBeaconUpgradedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(BEACONUPGRADED_EVENT, transactionReceipt);
        ArrayList<BeaconUpgradedEventResponse> responses = new ArrayList<BeaconUpgradedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            BeaconUpgradedEventResponse typedResponse = new BeaconUpgradedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.beacon = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static BeaconUpgradedEventResponse getBeaconUpgradedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(BEACONUPGRADED_EVENT, log);
        BeaconUpgradedEventResponse typedResponse = new BeaconUpgradedEventResponse();
        typedResponse.log = log;
        typedResponse.beacon = (String) eventValues.getIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<BeaconUpgradedEventResponse> beaconUpgradedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getBeaconUpgradedEventFromLog(log));
    }

    public Flowable<BeaconUpgradedEventResponse> beaconUpgradedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(BEACONUPGRADED_EVENT));
        return beaconUpgradedEventFlowable(filter);
    }

    public static List<InitializedEventResponse> getInitializedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(INITIALIZED_EVENT, transactionReceipt);
        ArrayList<InitializedEventResponse> responses = new ArrayList<InitializedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            InitializedEventResponse typedResponse = new InitializedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.version = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static InitializedEventResponse getInitializedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(INITIALIZED_EVENT, log);
        InitializedEventResponse typedResponse = new InitializedEventResponse();
        typedResponse.log = log;
        typedResponse.version = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<InitializedEventResponse> initializedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getInitializedEventFromLog(log));
    }

    public Flowable<InitializedEventResponse> initializedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(INITIALIZED_EVENT));
        return initializedEventFlowable(filter);
    }

    public static List<PausedEventResponse> getPausedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(PAUSED_EVENT, transactionReceipt);
        ArrayList<PausedEventResponse> responses = new ArrayList<PausedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PausedEventResponse typedResponse = new PausedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static PausedEventResponse getPausedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(PAUSED_EVENT, log);
        PausedEventResponse typedResponse = new PausedEventResponse();
        typedResponse.log = log;
        typedResponse.account = (String) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<PausedEventResponse> pausedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getPausedEventFromLog(log));
    }

    public Flowable<PausedEventResponse> pausedEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PAUSED_EVENT));
        return pausedEventFlowable(filter);
    }

    public static List<RoleAdminChangedEventResponse> getRoleAdminChangedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ROLEADMINCHANGED_EVENT, transactionReceipt);
        ArrayList<RoleAdminChangedEventResponse> responses = new ArrayList<RoleAdminChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RoleAdminChangedEventResponse typedResponse = new RoleAdminChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.previousAdminRole = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.newAdminRole = (byte[]) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static RoleAdminChangedEventResponse getRoleAdminChangedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(ROLEADMINCHANGED_EVENT, log);
        RoleAdminChangedEventResponse typedResponse = new RoleAdminChangedEventResponse();
        typedResponse.log = log;
        typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.previousAdminRole = (byte[]) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.newAdminRole = (byte[]) eventValues.getIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<RoleAdminChangedEventResponse> roleAdminChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getRoleAdminChangedEventFromLog(log));
    }

    public Flowable<RoleAdminChangedEventResponse> roleAdminChangedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ROLEADMINCHANGED_EVENT));
        return roleAdminChangedEventFlowable(filter);
    }

    public static List<RoleGrantedEventResponse> getRoleGrantedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ROLEGRANTED_EVENT, transactionReceipt);
        ArrayList<RoleGrantedEventResponse> responses = new ArrayList<RoleGrantedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RoleGrantedEventResponse typedResponse = new RoleGrantedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static RoleGrantedEventResponse getRoleGrantedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(ROLEGRANTED_EVENT, log);
        RoleGrantedEventResponse typedResponse = new RoleGrantedEventResponse();
        typedResponse.log = log;
        typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<RoleGrantedEventResponse> roleGrantedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getRoleGrantedEventFromLog(log));
    }

    public Flowable<RoleGrantedEventResponse> roleGrantedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ROLEGRANTED_EVENT));
        return roleGrantedEventFlowable(filter);
    }

    public static List<RoleRevokedEventResponse> getRoleRevokedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ROLEREVOKED_EVENT, transactionReceipt);
        ArrayList<RoleRevokedEventResponse> responses = new ArrayList<RoleRevokedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RoleRevokedEventResponse typedResponse = new RoleRevokedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static RoleRevokedEventResponse getRoleRevokedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(ROLEREVOKED_EVENT, log);
        RoleRevokedEventResponse typedResponse = new RoleRevokedEventResponse();
        typedResponse.log = log;
        typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<RoleRevokedEventResponse> roleRevokedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getRoleRevokedEventFromLog(log));
    }

    public Flowable<RoleRevokedEventResponse> roleRevokedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ROLEREVOKED_EVENT));
        return roleRevokedEventFlowable(filter);
    }

    public static List<UnpausedEventResponse> getUnpausedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(UNPAUSED_EVENT, transactionReceipt);
        ArrayList<UnpausedEventResponse> responses = new ArrayList<UnpausedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            UnpausedEventResponse typedResponse = new UnpausedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static UnpausedEventResponse getUnpausedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(UNPAUSED_EVENT, log);
        UnpausedEventResponse typedResponse = new UnpausedEventResponse();
        typedResponse.log = log;
        typedResponse.account = (String) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<UnpausedEventResponse> unpausedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getUnpausedEventFromLog(log));
    }

    public Flowable<UnpausedEventResponse> unpausedEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(UNPAUSED_EVENT));
        return unpausedEventFlowable(filter);
    }

    public static List<UpgradedEventResponse> getUpgradedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(UPGRADED_EVENT, transactionReceipt);
        ArrayList<UpgradedEventResponse> responses = new ArrayList<UpgradedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            UpgradedEventResponse typedResponse = new UpgradedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.implementation = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static UpgradedEventResponse getUpgradedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(UPGRADED_EVENT, log);
        UpgradedEventResponse typedResponse = new UpgradedEventResponse();
        typedResponse.log = log;
        typedResponse.implementation = (String) eventValues.getIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<UpgradedEventResponse> upgradedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getUpgradedEventFromLog(log));
    }

    public Flowable<UpgradedEventResponse> upgradedEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(UPGRADED_EVENT));
        return upgradedEventFlowable(filter);
    }

    public static List<WithdrawalEventResponse> getWithdrawalEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(WITHDRAWAL_EVENT, transactionReceipt);
        ArrayList<WithdrawalEventResponse> responses = new ArrayList<WithdrawalEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WithdrawalEventResponse typedResponse = new WithdrawalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.to = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static WithdrawalEventResponse getWithdrawalEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(WITHDRAWAL_EVENT, log);
        WithdrawalEventResponse typedResponse = new WithdrawalEventResponse();
        typedResponse.log = log;
        typedResponse.to = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<WithdrawalEventResponse> withdrawalEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getWithdrawalEventFromLog(log));
    }

    public Flowable<WithdrawalEventResponse> withdrawalEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WITHDRAWAL_EVENT));
        return withdrawalEventFlowable(filter);
    }

    public static List<WithdrawalFromOffchainEventResponse> getWithdrawalFromOffchainEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(WITHDRAWALFROMOFFCHAIN_EVENT, transactionReceipt);
        ArrayList<WithdrawalFromOffchainEventResponse> responses = new ArrayList<WithdrawalFromOffchainEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WithdrawalFromOffchainEventResponse typedResponse = new WithdrawalFromOffchainEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.to = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.offchainUUID = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.success = (Boolean) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static WithdrawalFromOffchainEventResponse getWithdrawalFromOffchainEventFromLog(
            Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(WITHDRAWALFROMOFFCHAIN_EVENT, log);
        WithdrawalFromOffchainEventResponse typedResponse = new WithdrawalFromOffchainEventResponse();
        typedResponse.log = log;
        typedResponse.to = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.offchainUUID = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
        typedResponse.success = (Boolean) eventValues.getNonIndexedValues().get(3).getValue();
        return typedResponse;
    }

    public Flowable<WithdrawalFromOffchainEventResponse> withdrawalFromOffchainEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getWithdrawalFromOffchainEventFromLog(log));
    }

    public Flowable<WithdrawalFromOffchainEventResponse> withdrawalFromOffchainEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WITHDRAWALFROMOFFCHAIN_EVENT));
        return withdrawalFromOffchainEventFlowable(filter);
    }

    public RemoteFunctionCall<byte[]> call_DEFAULT_ADMIN_ROLE() {
        final Function function = new Function(FUNC_DEFAULT_ADMIN_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_DEFAULT_ADMIN_ROLE() {
        final Function function = new Function(
                FUNC_DEFAULT_ADMIN_ROLE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<byte[]> call_PAUSER_ROLE() {
        final Function function = new Function(FUNC_PAUSER_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_PAUSER_ROLE() {
        final Function function = new Function(
                FUNC_PAUSER_ROLE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<byte[]> call_TRANSFER_ROLE() {
        final Function function = new Function(FUNC_TRANSFER_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_TRANSFER_ROLE() {
        final Function function = new Function(
                FUNC_TRANSFER_ROLE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<byte[]> call_UPGRADER_ROLE() {
        final Function function = new Function(FUNC_UPGRADER_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_UPGRADER_ROLE() {
        final Function function = new Function(
                FUNC_UPGRADER_ROLE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> call__eplToken() {
        final Function function = new Function(FUNC__EPLTOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send__eplToken() {
        final Function function = new Function(
                FUNC__EPLTOKEN, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<byte[]> call_getRoleAdmin(byte[] role) {
        final Function function = new Function(FUNC_GETROLEADMIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_getRoleAdmin(byte[] role) {
        final Function function = new Function(
                FUNC_GETROLEADMIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_grantRole(byte[] role, String account) {
        final Function function = new Function(
                FUNC_GRANTROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role), 
                new org.web3j.abi.datatypes.Address(account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> call_hasRole(byte[] role, String account) {
        final Function function = new Function(FUNC_HASROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role), 
                new org.web3j.abi.datatypes.Address(account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_hasRole(byte[] role, String account) {
        final Function function = new Function(
                FUNC_HASROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role), 
                new org.web3j.abi.datatypes.Address(account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> call_paused() {
        final Function function = new Function(FUNC_PAUSED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_paused() {
        final Function function = new Function(
                FUNC_PAUSED, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<byte[]> call_proxiableUUID() {
        final Function function = new Function(FUNC_PROXIABLEUUID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_proxiableUUID() {
        final Function function = new Function(
                FUNC_PROXIABLEUUID, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_renounceRole(byte[] role, String account) {
        final Function function = new Function(
                FUNC_RENOUNCEROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role), 
                new org.web3j.abi.datatypes.Address(account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_revokeRole(byte[] role, String account) {
        final Function function = new Function(
                FUNC_REVOKEROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role), 
                new org.web3j.abi.datatypes.Address(account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> call_supportsInterface(byte[] interfaceId) {
        final Function function = new Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_supportsInterface(byte[] interfaceId) {
        final Function function = new Function(
                FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_upgradeTo(String newImplementation) {
        final Function function = new Function(
                FUNC_UPGRADETO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newImplementation)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_upgradeToAndCall(String newImplementation,
            byte[] data, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_UPGRADETOANDCALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newImplementation), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> send_initialize(String eplToken_) {
        final Function function = new Function(
                FUNC_INITIALIZE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(eplToken_)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_pause() {
        final Function function = new Function(
                FUNC_PAUSE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_unpause() {
        final Function function = new Function(
                FUNC_UNPAUSE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_withdraw(String to, BigInteger amount) {
        final Function function = new Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_withdrawFromOffchain(String to,
            BigInteger amount, BigInteger offchainUUID) {
        final Function function = new Function(
                FUNC_WITHDRAWFROMOFFCHAIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.web3j.abi.datatypes.generated.Uint256(offchainUUID)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Treasury load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new Treasury(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Treasury load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Treasury(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Treasury load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new Treasury(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Treasury load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Treasury(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Treasury> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Treasury.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    public static RemoteCall<Treasury> deploy(Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Treasury.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<Treasury> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Treasury.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<Treasury> deploy(Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Treasury.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static void linkLibraries(List<Contract.LinkReference> references) {
        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class AdminChangedEventResponse extends BaseEventResponse {
        public String previousAdmin;

        public String newAdmin;
    }

    public static class BeaconUpgradedEventResponse extends BaseEventResponse {
        public String beacon;
    }

    public static class InitializedEventResponse extends BaseEventResponse {
        public BigInteger version;
    }

    public static class PausedEventResponse extends BaseEventResponse {
        public String account;
    }

    public static class RoleAdminChangedEventResponse extends BaseEventResponse {
        public byte[] role;

        public byte[] previousAdminRole;

        public byte[] newAdminRole;
    }

    public static class RoleGrantedEventResponse extends BaseEventResponse {
        public byte[] role;

        public String account;

        public String sender;
    }

    public static class RoleRevokedEventResponse extends BaseEventResponse {
        public byte[] role;

        public String account;

        public String sender;
    }

    public static class UnpausedEventResponse extends BaseEventResponse {
        public String account;
    }

    public static class UpgradedEventResponse extends BaseEventResponse {
        public String implementation;
    }

    public static class WithdrawalEventResponse extends BaseEventResponse {
        public String to;

        public BigInteger amount;
    }

    public static class WithdrawalFromOffchainEventResponse extends BaseEventResponse {
        public String to;

        public BigInteger amount;

        public BigInteger offchainUUID;

        public Boolean success;
    }
}
