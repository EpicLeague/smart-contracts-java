package contracts.tokenomics;

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
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
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
public class TreasuryVestingWallet extends Contract {
    public static final String BINARY = "0x61010060405234801561001157600080fd5b5060405161095438038061095483398101604081905261003091610097565b8282826319f488006001600160a01b03831661004b57600080fd5b6001600160a01b0393841660e052919092166080526001600160401b0391821660a0521660c052506100eb915050565b80516001600160a01b038116811461009257600080fd5b919050565b6000806000606084860312156100ac57600080fd5b6100b58461007b565b92506100c36020850161007b565b60408501519092506001600160401b03811681146100e057600080fd5b809150509250925092565b60805160a05160c05160e05161080f6101456000396000818161011701528181610176015261026601526000818160aa0152818161030b0152610360015260006102c301526000818160da0152610290015261080f6000f3fe608060405234801561001057600080fd5b506004361061007d5760003560e01c80634ae56a961161005b5780634ae56a961461011257806386d1a69f146101395780639613252114610143578063be9a65551461014b57600080fd5b80630a17b06b146100825780630fb5a6b4146100a857806338af3eed146100d8575b600080fd5b61009561009036600461066f565b610153565b6040519081526020015b60405180910390f35b7f000000000000000000000000000000000000000000000000000000000000000067ffffffffffffffff16610095565b7f00000000000000000000000000000000000000000000000000000000000000005b6040516001600160a01b03909116815260200161009f565b6100fa7f000000000000000000000000000000000000000000000000000000000000000081565b6101416101ff565b005b600054610095565b6100956102b8565b60006101f961016160005490565b6040516370a0823160e01b81523060048201527f00000000000000000000000000000000000000000000000000000000000000006001600160a01b0316906370a0823190602401602060405180830381865afa1580156101c5573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906101e99190610699565b6101f391906106c8565b836102e6565b92915050565b6000805461020c42610153565b61021691906106e0565b90508060008082825461022991906106c8565b90915550506040518181527faad5b3be061ab6eca724bb5396e143ce2155c3073ef2f483865407a1e2fdaf739060200160405180910390a16102b57f00000000000000000000000000000000000000000000000000000000000000006001600160a01b03167f0000000000000000000000000000000000000000000000000000000000000000836103c0565b50565b67ffffffffffffffff7f00000000000000000000000000000000000000000000000000000000000000001690565b60006102f06102b8565b8267ffffffffffffffff161015610309575060006101f9565b7f000000000000000000000000000000000000000000000000000000000000000067ffffffffffffffff1661033c6102b8565b61034691906106c8565b8267ffffffffffffffff16111561035e5750816101f9565b7f000000000000000000000000000000000000000000000000000000000000000067ffffffffffffffff166103916102b8565b6103a59067ffffffffffffffff85166106e0565b6103af90856106f7565b6103b99190610716565b9392505050565b604080516001600160a01b038416602482015260448082018490528251808303909101815260649091019091526020810180516001600160e01b031663a9059cbb60e01b179052610412908490610417565b505050565b600061046c826040518060400160405280602081526020017f5361666545524332303a206c6f772d6c6576656c2063616c6c206661696c6564815250856001600160a01b03166104ee9092919063ffffffff16565b805190915015610412578080602001905181019061048a9190610738565b6104125760405162461bcd60e51b815260206004820152602a60248201527f5361666545524332303a204552433230206f7065726174696f6e20646964206e6044820152691bdd081cdd58d8d9595960b21b60648201526084015b60405180910390fd5b60606104fd8484600085610505565b949350505050565b6060824710156105665760405162461bcd60e51b815260206004820152602660248201527f416464726573733a20696e73756666696369656e742062616c616e636520666f6044820152651c8818d85b1b60d21b60648201526084016104e5565b6001600160a01b0385163b6105bd5760405162461bcd60e51b815260206004820152601d60248201527f416464726573733a2063616c6c20746f206e6f6e2d636f6e747261637400000060448201526064016104e5565b600080866001600160a01b031685876040516105d9919061078a565b60006040518083038185875af1925050503d8060008114610616576040519150601f19603f3d011682016040523d82523d6000602084013e61061b565b606091505b509150915061062b828286610636565b979650505050505050565b606083156106455750816103b9565b8251156106555782518084602001fd5b8160405162461bcd60e51b81526004016104e591906107a6565b60006020828403121561068157600080fd5b813567ffffffffffffffff811681146103b957600080fd5b6000602082840312156106ab57600080fd5b5051919050565b634e487b7160e01b600052601160045260246000fd5b600082198211156106db576106db6106b2565b500190565b6000828210156106f2576106f26106b2565b500390565b6000816000190483118215151615610711576107116106b2565b500290565b60008261073357634e487b7160e01b600052601260045260246000fd5b500490565b60006020828403121561074a57600080fd5b815180151581146103b957600080fd5b60005b8381101561077557818101518382015260200161075d565b83811115610784576000848401525b50505050565b6000825161079c81846020870161075a565b9190910192915050565b60208152600082518060208401526107c581604085016020870161075a565b601f01601f1916919091016040019291505056fea264697066735822122033208ee6cb3ae4bdab2de4f0f97ea303c12dfe190533704690e24f96fbea201164736f6c634300080e0033";

    private static String librariesLinkedBinary;

    public static final String FUNC__EPLTOKEN = "_eplToken";

    public static final String FUNC_BENEFICIARY = "beneficiary";

    public static final String FUNC_DURATION = "duration";

    public static final String FUNC_RELEASE = "release";

    public static final String FUNC_RELEASED = "released";

    public static final String FUNC_START = "start";

    public static final String FUNC_VESTEDAMOUNT = "vestedAmount";

    public static final Event EPLRELEASED_EVENT = new Event("EPLReleased", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("1677429376372", "0xB61c8EC890797ACDCc6CE98bC3EeA1d787f1208F");
        _addresses.put("1", "0x4bb35A18c570c864F8c8f53c051e039443429079");
        _addresses.put("56", "0xA682B1804d3e77625eD469C6839651bB9D452610");
        _addresses.put("80001", "0xA29D2BC9131Db20e0b9BA02B7d5963003A04B452");
        _addresses.put("1662908282481", "0xaD888d0Ade988EbEe74B8D4F39BF29a8d0fe8A8D");
        _addresses.put("5", "0x2089BcECD323727C7C4838b1A734F84b4Cb65016");
        _addresses.put("137", "0x6455063143e5D126e67FB8fF3b22bB01c1834ee8");
        _addresses.put("19011", "0xC297E5685de0f815e587122FA8389A24b225205f");
        _addresses.put("40875", "0xD5409101C2B06809Fd8CC4A2d6bA4A0F1e1CDa33");
        _addresses.put("97", "0x78c19247bD1414306711F3C068D66d392fD52CA3");
    }

    @Deprecated
    protected TreasuryVestingWallet(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TreasuryVestingWallet(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TreasuryVestingWallet(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TreasuryVestingWallet(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<EPLReleasedEventResponse> getEPLReleasedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(EPLRELEASED_EVENT, transactionReceipt);
        ArrayList<EPLReleasedEventResponse> responses = new ArrayList<EPLReleasedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            EPLReleasedEventResponse typedResponse = new EPLReleasedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static EPLReleasedEventResponse getEPLReleasedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(EPLRELEASED_EVENT, log);
        EPLReleasedEventResponse typedResponse = new EPLReleasedEventResponse();
        typedResponse.log = log;
        typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<EPLReleasedEventResponse> ePLReleasedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getEPLReleasedEventFromLog(log));
    }

    public Flowable<EPLReleasedEventResponse> ePLReleasedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EPLRELEASED_EVENT));
        return ePLReleasedEventFlowable(filter);
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

    public RemoteFunctionCall<String> call_beneficiary() {
        final Function function = new Function(FUNC_BENEFICIARY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_beneficiary() {
        final Function function = new Function(
                FUNC_BENEFICIARY, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> call_duration() {
        final Function function = new Function(FUNC_DURATION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_duration() {
        final Function function = new Function(
                FUNC_DURATION, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_release() {
        final Function function = new Function(
                FUNC_RELEASE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> call_released() {
        final Function function = new Function(FUNC_RELEASED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_released() {
        final Function function = new Function(
                FUNC_RELEASED, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> call_start() {
        final Function function = new Function(FUNC_START, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_start() {
        final Function function = new Function(
                FUNC_START, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> call_vestedAmount(BigInteger timestamp) {
        final Function function = new Function(FUNC_VESTEDAMOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint64(timestamp)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_vestedAmount(BigInteger timestamp) {
        final Function function = new Function(
                FUNC_VESTEDAMOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint64(timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static TreasuryVestingWallet load(String contractAddress, Web3j web3j,
            Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TreasuryVestingWallet(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TreasuryVestingWallet load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TreasuryVestingWallet(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TreasuryVestingWallet load(String contractAddress, Web3j web3j,
            Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TreasuryVestingWallet(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TreasuryVestingWallet load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TreasuryVestingWallet(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TreasuryVestingWallet> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider, String eplTokenAddress,
            String beneficiaryAddress, BigInteger startTimestamp) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(eplTokenAddress), 
                new org.web3j.abi.datatypes.Address(beneficiaryAddress), 
                new org.web3j.abi.datatypes.generated.Uint64(startTimestamp)));
        return deployRemoteCall(TreasuryVestingWallet.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    public static RemoteCall<TreasuryVestingWallet> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider,
            String eplTokenAddress, String beneficiaryAddress, BigInteger startTimestamp) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(eplTokenAddress), 
                new org.web3j.abi.datatypes.Address(beneficiaryAddress), 
                new org.web3j.abi.datatypes.generated.Uint64(startTimestamp)));
        return deployRemoteCall(TreasuryVestingWallet.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<TreasuryVestingWallet> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit, String eplTokenAddress,
            String beneficiaryAddress, BigInteger startTimestamp) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(eplTokenAddress), 
                new org.web3j.abi.datatypes.Address(beneficiaryAddress), 
                new org.web3j.abi.datatypes.generated.Uint64(startTimestamp)));
        return deployRemoteCall(TreasuryVestingWallet.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<TreasuryVestingWallet> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit,
            String eplTokenAddress, String beneficiaryAddress, BigInteger startTimestamp) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(eplTokenAddress), 
                new org.web3j.abi.datatypes.Address(beneficiaryAddress), 
                new org.web3j.abi.datatypes.generated.Uint64(startTimestamp)));
        return deployRemoteCall(TreasuryVestingWallet.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
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

    public static class EPLReleasedEventResponse extends BaseEventResponse {
        public BigInteger amount;
    }
}
