package contracts.nft.v1;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
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
public class TotemBoxOpener extends Contract {
    public static final String BINARY = "0x608060405234801561001057600080fd5b50604051610e35380380610e3583398101604081905261002f9161012e565b600180546001600160a81b0319166101006001600160a01b0384160217905561005f600061005a3390565b61008f565b6100897f241ecf16d79d0f8dbfb92cbc07fe17840425976cf0667f022fe9877caa831b083361008f565b5061015e565b6000828152602081815260408083206001600160a01b038516845290915290205460ff1661012a576000828152602081815260408083206001600160a01b03851684529091529020805460ff191660011790556100e93390565b6001600160a01b0316816001600160a01b0316837f2f8788117e7eff1d82e926ec794901d17c78024a50270940304540a733656f0d60405160405180910390a45b5050565b60006020828403121561014057600080fd5b81516001600160a01b038116811461015757600080fd5b9392505050565b610cc88061016d6000396000f3fe608060405234801561001057600080fd5b50600436106100ea5760003560e01c806349b5208d1161008c578063a217fddf11610066578063a217fddf146101f8578063a91be53614610200578063d547741f14610213578063ec87621c1461022657600080fd5b806349b5208d146101c75780635c975abb146101da57806391d14854146101e557600080fd5b80632f2ff15d116100c85780632f2ff15d1461015d5780632fd304c21461017057806336568abe146101a15780634348bac6146101b457600080fd5b806301ffc9a7146100ef57806310ac1d3e14610117578063248a9ca31461012c575b600080fd5b6101026100fd3660046109dd565b61023b565b60405190151581526020015b60405180910390f35b61012a610125366004610a23565b610272565b005b61014f61013a366004610a4d565b60009081526020819052604090206001015490565b60405190815260200161010e565b61012a61016b366004610a66565b61046a565b61010261017e366004610a92565b6001600160a01b031660009081526002602052604090205460ff16151560011490565b61012a6101af366004610a66565b610494565b61012a6101c2366004610a92565b610512565b61012a6101d5366004610a92565b610575565b60015460ff16610102565b6101026101f3366004610a66565b6105d5565b61014f600081565b61012a61020e366004610a92565b6105fe565b61012a610221366004610a66565b6106bb565b61014f600080516020610c7383398151915281565b60006001600160e01b03198216637965db0b60e01b148061026c57506301ffc9a760e01b6001600160e01b03198316145b92915050565b8161029a816001600160a01b031660009081526002602052604090205460ff16151560011490565b6103115760405162461bcd60e51b815260206004820152603e60248201527f546f74656d426f784f70656e65723a204f6e6c7920746865207265676973746560448201527f72656420636f6e747261637420616464726573732069732076616c69642e000060648201526084015b60405180910390fd5b60015460ff16156103575760405162461bcd60e51b815260206004820152601060248201526f14185d5cd8589b194e881c185d5cd95960821b6044820152606401610308565b604051630852cd8d60e31b81526004810183905283906001600160a01b038216906342966c6890602401600060405180830381600087803b15801561039b57600080fd5b505af11580156103af573d6000803e3d6000fd5b505060015461010090046001600160a01b0316915081905063a1448194336040516001600160e01b031960e084901b1681526001600160a01b03909116600482015260248101879052604401600060405180830381600087803b15801561041557600080fd5b505af1158015610429573d6000803e3d6000fd5b50506040518692506001600160a01b03881691507f206662e8a13885ae7b251c433a54eeb2345385950cac534098f607252ecb94e090600090a35050505050565b600082815260208190526040902060010154610485816106e0565b61048f83836106ed565b505050565b6001600160a01b03811633146105045760405162461bcd60e51b815260206004820152602f60248201527f416363657373436f6e74726f6c3a2063616e206f6e6c792072656e6f756e636560448201526e103937b632b9903337b91039b2b63360891b6064820152608401610308565b61050e8282610771565b5050565b600080516020610c7383398151915261052a816106e0565b6001600160a01b0382166105505760405162461bcd60e51b815260040161030890610aad565b506001600160a01b03166000908152600260205260409020805460ff19166001179055565b600080516020610c7383398151915261058d816106e0565b6001600160a01b0382166105b35760405162461bcd60e51b815260040161030890610aad565b506001600160a01b03166000908152600260205260409020805460ff19169055565b6000918252602082815260408084206001600160a01b0393909316845291905290205460ff1690565b600080516020610c73833981519152610616816106e0565b6001600160a01b0382166106925760405162461bcd60e51b815260206004820152603760248201527f546f74656d426f784f70656e65723a2053657420546f74656d20436f6e74726160448201527f637420666f7220746865207a65726f20616464726573730000000000000000006064820152608401610308565b50600180546001600160a01b0390921661010002610100600160a81b0319909216919091179055565b6000828152602081905260409020600101546106d6816106e0565b61048f8383610771565b6106ea81336107d6565b50565b6106f782826105d5565b61050e576000828152602081815260408083206001600160a01b03851684529091529020805460ff1916600117905561072d3390565b6001600160a01b0316816001600160a01b0316837f2f8788117e7eff1d82e926ec794901d17c78024a50270940304540a733656f0d60405160405180910390a45050565b61077b82826105d5565b1561050e576000828152602081815260408083206001600160a01b0385168085529252808320805460ff1916905551339285917ff6391f5c32d9c69d2a47ea670b442974b53935d1edc7fd64eb21e047a839171b9190a45050565b6107e082826105d5565b61050e576107f8816001600160a01b0316601461083a565b61080383602061083a565b604051602001610814929190610b3a565b60408051601f198184030181529082905262461bcd60e51b825261030891600401610baf565b60606000610849836002610bf8565b610854906002610c17565b67ffffffffffffffff81111561086c5761086c610c2f565b6040519080825280601f01601f191660200182016040528015610896576020820181803683370190505b509050600360fc1b816000815181106108b1576108b1610c45565b60200101906001600160f81b031916908160001a905350600f60fb1b816001815181106108e0576108e0610c45565b60200101906001600160f81b031916908160001a9053506000610904846002610bf8565b61090f906001610c17565b90505b6001811115610987576f181899199a1a9b1b9c1cb0b131b232b360811b85600f166010811061094357610943610c45565b1a60f81b82828151811061095957610959610c45565b60200101906001600160f81b031916908160001a90535060049490941c9361098081610c5b565b9050610912565b5083156109d65760405162461bcd60e51b815260206004820181905260248201527f537472696e67733a20686578206c656e67746820696e73756666696369656e746044820152606401610308565b9392505050565b6000602082840312156109ef57600080fd5b81356001600160e01b0319811681146109d657600080fd5b80356001600160a01b0381168114610a1e57600080fd5b919050565b60008060408385031215610a3657600080fd5b610a3f83610a07565b946020939093013593505050565b600060208284031215610a5f57600080fd5b5035919050565b60008060408385031215610a7957600080fd5b82359150610a8960208401610a07565b90509250929050565b600060208284031215610aa457600080fd5b6109d682610a07565b6020808252603f908201527f546f74656d426f784f70656e65723a20526567697374657220546f74656d426f60408201527f7820436f6e747261637420666f7220746865207a65726f206164647265737300606082015260800190565b60005b83811015610b25578181015183820152602001610b0d565b83811115610b34576000848401525b50505050565b7f416363657373436f6e74726f6c3a206163636f756e7420000000000000000000815260008351610b72816017850160208801610b0a565b7001034b99036b4b9b9b4b733903937b6329607d1b6017918401918201528351610ba3816028840160208801610b0a565b01602801949350505050565b6020815260008251806020840152610bce816040850160208701610b0a565b601f01601f19169190910160400192915050565b634e487b7160e01b600052601160045260246000fd5b6000816000190483118215151615610c1257610c12610be2565b500290565b60008219821115610c2a57610c2a610be2565b500190565b634e487b7160e01b600052604160045260246000fd5b634e487b7160e01b600052603260045260246000fd5b600081610c6a57610c6a610be2565b50600019019056fe241ecf16d79d0f8dbfb92cbc07fe17840425976cf0667f022fe9877caa831b08a26469706673582212202b82d0cad7ba6922f12b964206d4f27ea25f2abb337c2ab08b01b10734a22d9964736f6c634300080e0033";

    private static String librariesLinkedBinary;

    public static final String FUNC_DEFAULT_ADMIN_ROLE = "DEFAULT_ADMIN_ROLE";

    public static final String FUNC_MANAGER_ROLE = "MANAGER_ROLE";

    public static final String FUNC_GETROLEADMIN = "getRoleAdmin";

    public static final String FUNC_GRANTROLE = "grantRole";

    public static final String FUNC_HASROLE = "hasRole";

    public static final String FUNC_PAUSED = "paused";

    public static final String FUNC_RENOUNCEROLE = "renounceRole";

    public static final String FUNC_REVOKEROLE = "revokeRole";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_UNBOX = "unbox";

    public static final String FUNC_ISREGISTEREDTOTEMBOXCONTRACT = "isRegisteredTotemBoxContract";

    public static final String FUNC_REGISTERTOTEMBOXCONTRACT = "registerTotemBoxContract";

    public static final String FUNC_DEREGISTERTOTEMBOXCONTRACT = "deregisterTotemBoxContract";

    public static final String FUNC_SETTOTEMCONTRACT = "setTotemContract";

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

    public static final Event UNBOXED_EVENT = new Event("Unboxed", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event UNPAUSED_EVENT = new Event("Unpaused", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("1677429376372", "0x0Bd791e3E133992C7aEFc5AED93d8A0C48Dd6762");
        _addresses.put("80001", "0xb0b7C272647A9F0Cd9A75864a6395240d73c82dD");
        _addresses.put("137", "0x647Aae7B6b1C46De037111657A50297da34FC359");
        _addresses.put("19011", "0xEb1b870ef34b5b6960E2857F9283A6e99175CBf7");
        _addresses.put("40875", "0x952463EB27DDFE677943C7773962366eA5c79708");
    }

    @Deprecated
    protected TotemBoxOpener(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TotemBoxOpener(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TotemBoxOpener(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TotemBoxOpener(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
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

    public static List<UnboxedEventResponse> getUnboxedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(UNBOXED_EVENT, transactionReceipt);
        ArrayList<UnboxedEventResponse> responses = new ArrayList<UnboxedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            UnboxedEventResponse typedResponse = new UnboxedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.boxContract = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static UnboxedEventResponse getUnboxedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(UNBOXED_EVENT, log);
        UnboxedEventResponse typedResponse = new UnboxedEventResponse();
        typedResponse.log = log;
        typedResponse.boxContract = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<UnboxedEventResponse> unboxedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getUnboxedEventFromLog(log));
    }

    public Flowable<UnboxedEventResponse> unboxedEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(UNBOXED_EVENT));
        return unboxedEventFlowable(filter);
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

    public RemoteFunctionCall<TransactionReceipt> send_unbox(String boxContract,
            BigInteger tokenId) {
        final Function function = new Function(
                FUNC_UNBOX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(boxContract), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> call_isRegisteredTotemBoxContract(String boxContract) {
        final Function function = new Function(FUNC_ISREGISTEREDTOTEMBOXCONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(boxContract)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_isRegisteredTotemBoxContract(
            String boxContract) {
        final Function function = new Function(
                FUNC_ISREGISTEREDTOTEMBOXCONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(boxContract)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_registerTotemBoxContract(
            String boxContract) {
        final Function function = new Function(
                FUNC_REGISTERTOTEMBOXCONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(boxContract)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_deregisterTotemBoxContract(
            String boxContract) {
        final Function function = new Function(
                FUNC_DEREGISTERTOTEMBOXCONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(boxContract)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_setTotemContract(String totemContract) {
        final Function function = new Function(
                FUNC_SETTOTEMCONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(totemContract)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static TotemBoxOpener load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new TotemBoxOpener(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TotemBoxOpener load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TotemBoxOpener(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TotemBoxOpener load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new TotemBoxOpener(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TotemBoxOpener load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TotemBoxOpener(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TotemBoxOpener> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider, String totemContract) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(totemContract)));
        return deployRemoteCall(TotemBoxOpener.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    public static RemoteCall<TotemBoxOpener> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider,
            String totemContract) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(totemContract)));
        return deployRemoteCall(TotemBoxOpener.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<TotemBoxOpener> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit, String totemContract) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(totemContract)));
        return deployRemoteCall(TotemBoxOpener.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<TotemBoxOpener> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit,
            String totemContract) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(totemContract)));
        return deployRemoteCall(TotemBoxOpener.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
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

    public static class UnboxedEventResponse extends BaseEventResponse {
        public String boxContract;

        public BigInteger tokenId;
    }

    public static class UnpausedEventResponse extends BaseEventResponse {
        public String account;
    }
}
