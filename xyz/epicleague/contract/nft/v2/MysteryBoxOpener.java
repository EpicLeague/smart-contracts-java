package xyz.epicleague.contract.nft.v2;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Array;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
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
public class MysteryBoxOpener extends Contract {
    public static final String BINARY = "0x60a0604052600060045534801561001557600080fd5b50604051620014ed380380620014ed83398101604081905261003691610295565b6001805460ff191690556001600160a01b0381166080526100586000336101e9565b506100837f241ecf16d79d0f8dbfb92cbc07fe17840425976cf0667f022fe9877caa831b08336101e9565b50506040805180820182526908479d80d7524d7000008152600160208083018281526005805480850182556000828152955160029182027f036b6384b5eca791c62761152d0c79bb0604c104a5fb6f4eb0703f3154bb3db08181019290925593517f036b6384b5eca791c62761152d0c79bb0604c104a5fb6f4eb0703f3154bb3db1948501558751808901895268d3f6267beea15800008152601381870190815284548089018655858a52915191840280840192909255519085015587518089018952681532370c64a9bc00008152608c81870190815284548089018655858a5291519184028084019290925551908501558751808901895268021e9f1ad6ddc60000815261098881870190815284548089018655858a52915191840280840192909255519085015587518089019098526736431c48afc700008852611ce8948801948552825495860183559190955294519290930293840191909155519101556102c5565b6000828152602081815260408083206001600160a01b038516845290915281205460ff1661028b576000838152602081815260408083206001600160a01b03861684529091529020805460ff191660011790556102433390565b6001600160a01b0316826001600160a01b0316847f2f8788117e7eff1d82e926ec794901d17c78024a50270940304540a733656f0d60405160405180910390a450600161028f565b5060005b92915050565b6000602082840312156102a757600080fd5b81516001600160a01b03811681146102be57600080fd5b9392505050565b6080516111fe620002ef600039600081816102b0015281816106c6015261086201526111fe6000f3fe608060405234801561001057600080fd5b50600436106101515760003560e01c80637c711b27116100cd578063d547741f11610081578063ec87621c11610066578063ec87621c146102f8578063ecbd743d1461031f578063ff2011141461033257600080fd5b8063d547741f146102d2578063ddbe9249146102e557600080fd5b806391d14854116100b257806391d148541461026c578063a217fddf146102a3578063c38b761c146102ab57600080fd5b80637c711b271461023b5780638456cb591461026457600080fd5b806336568abe116101245780635351b261116101095780635351b261146101f25780635c975abb146102055780636c93266a1461021057600080fd5b806336568abe146101d75780633f4ba83a146101ea57600080fd5b806301ffc9a714610156578063248a9ca31461017e57806325dfa04a146101af5780632f2ff15d146101c4575b600080fd5b610169610164366004610fd0565b61035a565b60405190151581526020015b60405180910390f35b6101a161018c366004611001565b60009081526020819052604090206001015490565b604051908152602001610175565b6101c26101bd366004611001565b6103c3565b005b6101c26101d2366004611036565b6104eb565b6101c26101e5366004611036565b610516565b6101c2610567565b6101c2610200366004611062565b61059c565b60015460ff16610169565b600354610223906001600160a01b031681565b6040516001600160a01b039091168152602001610175565b610223610249366004611001565b6002602052600090815260409020546001600160a01b031681565b6101c26105f6565b61016961027a366004611036565b6000918252602082815260408084206001600160a01b0393909316845291905290205460ff1690565b6101a1600081565b6102237f000000000000000000000000000000000000000000000000000000000000000081565b6101c26102e0366004611036565b610628565b6101c26102f3366004611036565b61064d565b6101a17f241ecf16d79d0f8dbfb92cbc07fe17840425976cf0667f022fe9877caa831b0881565b6101c261032d36600461107d565b6106b3565b610345610340366004611001565b610bda565b60408051928352602083019190915201610175565b60006001600160e01b031982167f7965db0b0000000000000000000000000000000000000000000000000000000014806103bd57507f01ffc9a7000000000000000000000000000000000000000000000000000000006001600160e01b03198316145b92915050565b7f241ecf16d79d0f8dbfb92cbc07fe17840425976cf0667f022fe9877caa831b086103ed81610c08565b6003546001600160a01b031663a9059cbb336040516001600160e01b031960e084901b1681526001600160a01b039091166004820152602481018590526044016020604051808303816000875af115801561044c573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610470919061109f565b6104e75760405162461bcd60e51b815260206004820152602360248201527f4d797374657279426f784f70656e65723a205769746864726177616c2066616960448201527f6c6564000000000000000000000000000000000000000000000000000000000060648201526084015b60405180910390fd5b5050565b60008281526020819052604090206001015461050681610c08565b6105108383610c12565b50505050565b6001600160a01b0381163314610558576040517f6697b23200000000000000000000000000000000000000000000000000000000815260040160405180910390fd5b6105628282610cbc565b505050565b7f241ecf16d79d0f8dbfb92cbc07fe17840425976cf0667f022fe9877caa831b0861059181610c08565b610599610d3f565b50565b7f241ecf16d79d0f8dbfb92cbc07fe17840425976cf0667f022fe9877caa831b086105c681610c08565b506003805473ffffffffffffffffffffffffffffffffffffffff19166001600160a01b0392909216919091179055565b7f241ecf16d79d0f8dbfb92cbc07fe17840425976cf0667f022fe9877caa831b0861062081610c08565b610599610d91565b60008281526020819052604090206001015461064381610c08565b6105108383610cbc565b7f241ecf16d79d0f8dbfb92cbc07fe17840425976cf0667f022fe9877caa831b0861067781610c08565b50600091825260026020526040909120805473ffffffffffffffffffffffffffffffffffffffff19166001600160a01b03909216919091179055565b6106bb610dcc565b806001600160a01b037f00000000000000000000000000000000000000000000000000000000000000001662fdd58e336040516001600160e01b031960e084901b1681526001600160a01b03909116600482015260248101869052604401602060405180830381865afa158015610736573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061075a91906110c1565b10156107ce5760405162461bcd60e51b815260206004820152602f60248201527f4d797374657279426f784f70656e65723a204e6f7420656e6f756768204d797360448201527f74657279426f7820746f206f70656e000000000000000000000000000000000060648201526084016104de565b6000828152600260205260409020546001600160a01b03166108585760405162461bcd60e51b815260206004820152602860248201527f4d797374657279426f784f70656e65723a204e465420636f6c6c656374696f6e60448201527f206e6f742073657400000000000000000000000000000000000000000000000060648201526084016104de565b6001600160a01b037f00000000000000000000000000000000000000000000000000000000000000001663f5298aca336040516001600160e01b031960e084901b1681526001600160a01b0390911660048201526024810185905260448101849052606401600060405180830381600087803b1580156108d757600080fd5b505af11580156108eb573d6000803e3d6000fd5b5050505060008167ffffffffffffffff81111561090a5761090a6110da565b604051908082528060200260200182016040528015610933578160200160208202803683370190505b50905060005b828110156109ee576000848152600260205260409020546001600160a01b03166340d097c3336040516001600160e01b031960e084901b1681526001600160a01b0390911660048201526024016020604051808303816000875af11580156109a5573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906109c991906110c1565b8282815181106109db576109db6110f0565b6020908102919091010152600101610939565b5060006109fa83610e0b565b90508015610b8d576003546040517f70a082310000000000000000000000000000000000000000000000000000000081523060048201526000916001600160a01b0316906370a0823190602401602060405180830381865afa158015610a64573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610a8891906110c1565b905081811015610a96578091505b6003546001600160a01b031663a9059cbb336040516001600160e01b031960e084901b1681526001600160a01b039091166004820152602481018590526044016020604051808303816000875af1158015610af5573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610b19919061109f565b610b8b5760405162461bcd60e51b815260206004820152602560248201527f4d797374657279426f784f70656e65723a2045504c207472616e73666572206660448201527f61696c656400000000000000000000000000000000000000000000000000000060648201526084016104de565b505b336001600160a01b03167ff5d0d5ee7e1c66eea3826248256863aef615520499e80ba604ef57522350476c85858486604051610bcc9493929190611106565b60405180910390a250505050565b60058181548110610bea57600080fd5b60009182526020909120600290910201805460019091015490915082565b6105998133610f28565b6000828152602081815260408083206001600160a01b038516845290915281205460ff16610cb4576000838152602081815260408083206001600160a01b03861684529091529020805460ff19166001179055610c6c3390565b6001600160a01b0316826001600160a01b0316847f2f8788117e7eff1d82e926ec794901d17c78024a50270940304540a733656f0d60405160405180910390a45060016103bd565b5060006103bd565b6000828152602081815260408083206001600160a01b038516845290915281205460ff1615610cb4576000838152602081815260408083206001600160a01b0386168085529252808320805460ff1916905551339286917ff6391f5c32d9c69d2a47ea670b442974b53935d1edc7fd64eb21e047a839171b9190a45060016103bd565b610d47610f94565b6001805460ff191690557f5db9ee0a495bf2e6ff9c91a7834c1ba4fdd244a5e8aa4e537bd38aeae4b073aa335b6040516001600160a01b03909116815260200160405180910390a1565b610d99610dcc565b6001805460ff1916811790557f62e78cea01bee320cd4e420270b5ea74000d11b0c9f74754ebdbfc544b05a25833610d74565b60015460ff1615610e09576040517fd93c066500000000000000000000000000000000000000000000000000000000815260040160405180910390fd5b565b6000805b82811015610f225760006127104233600454604051602001610e569392919092835260609190911b6bffffffffffffffffffffffff19166020830152603482015260540190565b6040516020818303038152906040528051906020012060001c610e799190611164565b600480549192506000610e8b8361119c565b91905055506000805b600554811015610f175760058181548110610eb157610eb16110f0565b90600052602060002090600202016001015482610ece91906111b5565b915081831015610f0f5760058181548110610eeb57610eeb6110f0565b90600052602060002090600202016000015485610f0891906111b5565b9450610f17565b600101610e94565b505050600101610e0f565b50919050565b6000828152602081815260408083206001600160a01b038516845290915290205460ff166104e7576040517fe2517d3f0000000000000000000000000000000000000000000000000000000081526001600160a01b0382166004820152602481018390526044016104de565b60015460ff16610e09576040517f8dfc202b00000000000000000000000000000000000000000000000000000000815260040160405180910390fd5b600060208284031215610fe257600080fd5b81356001600160e01b031981168114610ffa57600080fd5b9392505050565b60006020828403121561101357600080fd5b5035919050565b80356001600160a01b038116811461103157600080fd5b919050565b6000806040838503121561104957600080fd5b823591506110596020840161101a565b90509250929050565b60006020828403121561107457600080fd5b610ffa8261101a565b6000806040838503121561109057600080fd5b50508035926020909101359150565b6000602082840312156110b157600080fd5b81518015158114610ffa57600080fd5b6000602082840312156110d357600080fd5b5051919050565b634e487b7160e01b600052604160045260246000fd5b634e487b7160e01b600052603260045260246000fd5b60006080820186835260208660208501528560408501526080606085015281855180845260a08601915060208701935060005b8181101561115557845183529383019391830191600101611139565b50909998505050505050505050565b60008261118157634e487b7160e01b600052601260045260246000fd5b500690565b634e487b7160e01b600052601160045260246000fd5b6000600182016111ae576111ae611186565b5060010190565b808201808211156103bd576103bd61118656fea2646970667358221220752de601b0494116a96db69e55877c0d5f52bba42e28f4b61bc48c245cbdfec864736f6c63430008180033";

    private static String librariesLinkedBinary;

    public static final String FUNC_DEFAULT_ADMIN_ROLE = "DEFAULT_ADMIN_ROLE";

    public static final String FUNC_MANAGER_ROLE = "MANAGER_ROLE";

    public static final String FUNC_EPLTOKEN = "eplToken";

    public static final String FUNC_GETROLEADMIN = "getRoleAdmin";

    public static final String FUNC_GRANTROLE = "grantRole";

    public static final String FUNC_HASROLE = "hasRole";

    public static final String FUNC_MYSTERYBOX = "mysteryBox";

    public static final String FUNC_NFTCOLLECTION = "nftCollection";

    public static final String FUNC_OPENMYSTERYBOX = "openMysteryBox";

    public static final String FUNC_PAUSE = "pause";

    public static final String FUNC_PAUSED = "paused";

    public static final String FUNC_RENOUNCEROLE = "renounceRole";

    public static final String FUNC_REVOKEROLE = "revokeRole";

    public static final String FUNC_REWARDTIERS = "rewardTiers";

    public static final String FUNC_SETEPLTOKEN = "setEPLToken";

    public static final String FUNC_SETNFTCOLLECTION = "setNFTCollection";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_UNPAUSE = "unpause";

    public static final String FUNC_WITHDRAWEPL = "withdrawEPL";

    public static final Event MYSTERYBOXOPENED_EVENT = new Event("MysteryBoxOpened", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicArray<Uint256>>() {}));
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

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected MysteryBoxOpener(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MysteryBoxOpener(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MysteryBoxOpener(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MysteryBoxOpener(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<MysteryBoxOpenedEventResponse> getMysteryBoxOpenedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(MYSTERYBOXOPENED_EVENT, transactionReceipt);
        ArrayList<MysteryBoxOpenedEventResponse> responses = new ArrayList<MysteryBoxOpenedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MysteryBoxOpenedEventResponse typedResponse = new MysteryBoxOpenedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.user = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.itemId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.eplReward = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.tokenIds = (List<BigInteger>) ((Array) eventValues.getNonIndexedValues().get(3)).getNativeValueCopy();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static MysteryBoxOpenedEventResponse getMysteryBoxOpenedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(MYSTERYBOXOPENED_EVENT, log);
        MysteryBoxOpenedEventResponse typedResponse = new MysteryBoxOpenedEventResponse();
        typedResponse.log = log;
        typedResponse.user = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.itemId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.eplReward = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
        typedResponse.tokenIds = (List<BigInteger>) ((Array) eventValues.getNonIndexedValues().get(3)).getNativeValueCopy();
        return typedResponse;
    }

    public Flowable<MysteryBoxOpenedEventResponse> mysteryBoxOpenedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getMysteryBoxOpenedEventFromLog(log));
    }

    public Flowable<MysteryBoxOpenedEventResponse> mysteryBoxOpenedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MYSTERYBOXOPENED_EVENT));
        return mysteryBoxOpenedEventFlowable(filter);
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

    public RemoteFunctionCall<byte[]> call_MANAGER_ROLE() {
        final Function function = new Function(FUNC_MANAGER_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_MANAGER_ROLE() {
        final Function function = new Function(
                FUNC_MANAGER_ROLE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> call_eplToken() {
        final Function function = new Function(FUNC_EPLTOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_eplToken() {
        final Function function = new Function(
                FUNC_EPLTOKEN, 
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

    public RemoteFunctionCall<String> call_mysteryBox() {
        final Function function = new Function(FUNC_MYSTERYBOX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_mysteryBox() {
        final Function function = new Function(
                FUNC_MYSTERYBOX, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> call_nftCollection(BigInteger param0) {
        final Function function = new Function(FUNC_NFTCOLLECTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_nftCollection(BigInteger param0) {
        final Function function = new Function(
                FUNC_NFTCOLLECTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_openMysteryBox(BigInteger itemId,
            BigInteger amount) {
        final Function function = new Function(
                FUNC_OPENMYSTERYBOX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(itemId), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
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

    public RemoteFunctionCall<TransactionReceipt> send_renounceRole(byte[] role,
            String callerConfirmation) {
        final Function function = new Function(
                FUNC_RENOUNCEROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role), 
                new org.web3j.abi.datatypes.Address(callerConfirmation)), 
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

    public RemoteFunctionCall<Tuple2<BigInteger, BigInteger>> call_rewardTiers(BigInteger param0) {
        final Function function = new Function(FUNC_REWARDTIERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple2<BigInteger, BigInteger>>(function,
                new Callable<Tuple2<BigInteger, BigInteger>>() {
                    @Override
                    public Tuple2<BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> send_rewardTiers(BigInteger param0) {
        final Function function = new Function(
                FUNC_REWARDTIERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_setEPLToken(String _eplToken) {
        final Function function = new Function(
                FUNC_SETEPLTOKEN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_eplToken)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_setNFTCollection(BigInteger itemId,
            String nftContract) {
        final Function function = new Function(
                FUNC_SETNFTCOLLECTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(itemId), 
                new org.web3j.abi.datatypes.Address(nftContract)), 
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

    public RemoteFunctionCall<TransactionReceipt> send_unpause() {
        final Function function = new Function(
                FUNC_UNPAUSE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_withdrawEPL(BigInteger amount) {
        final Function function = new Function(
                FUNC_WITHDRAWEPL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static MysteryBoxOpener load(String contractAddress, Web3j web3j,
            Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MysteryBoxOpener(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MysteryBoxOpener load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MysteryBoxOpener(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MysteryBoxOpener load(String contractAddress, Web3j web3j,
            Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MysteryBoxOpener(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MysteryBoxOpener load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MysteryBoxOpener(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MysteryBoxOpener> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider, String _mysteryBox) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_mysteryBox)));
        return deployRemoteCall(MysteryBoxOpener.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    public static RemoteCall<MysteryBoxOpener> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider,
            String _mysteryBox) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_mysteryBox)));
        return deployRemoteCall(MysteryBoxOpener.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MysteryBoxOpener> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit, String _mysteryBox) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_mysteryBox)));
        return deployRemoteCall(MysteryBoxOpener.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MysteryBoxOpener> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit,
            String _mysteryBox) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_mysteryBox)));
        return deployRemoteCall(MysteryBoxOpener.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
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

    public static class MysteryBoxOpenedEventResponse extends BaseEventResponse {
        public String user;

        public BigInteger itemId;

        public BigInteger amount;

        public BigInteger eplReward;

        public List<BigInteger> tokenIds;
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
}
