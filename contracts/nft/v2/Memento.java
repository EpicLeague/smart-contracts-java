package contracts.nft.v2;

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
import org.web3j.abi.datatypes.Utf8String;
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
public class Memento extends Contract {
    public static final String BINARY = "0x60806040526001600d553480156200001657600080fd5b506040516200231e3803806200231e8339810160408190526200003991620001e9565b604051806040016040528060078152602001664d656d656e746f60c81b8152506040518060400160405280600381526020016213535560ea1b81525081600090816200008691906200034f565b5060016200009582826200034f565b5050600b805460ff1916905550620000af60003362000120565b50620000dc7f241ecf16d79d0f8dbfb92cbc07fe17840425976cf0667f022fe9877caa831b083362000120565b50620001097f9f2df0fed2c77648de5860a4cc508cd0818c85b8b8a1ab4ceeef8d981c8956a63362000120565b50600e6200011882826200034f565b50506200041b565b6000828152600c602090815260408083206001600160a01b038516845290915281205460ff16620001c9576000838152600c602090815260408083206001600160a01b03861684529091529020805460ff19166001179055620001803390565b6001600160a01b0316826001600160a01b0316847f2f8788117e7eff1d82e926ec794901d17c78024a50270940304540a733656f0d60405160405180910390a4506001620001cd565b5060005b92915050565b634e487b7160e01b600052604160045260246000fd5b60006020808385031215620001fd57600080fd5b82516001600160401b03808211156200021557600080fd5b818501915085601f8301126200022a57600080fd5b8151818111156200023f576200023f620001d3565b604051601f8201601f19908116603f011681019083821181831017156200026a576200026a620001d3565b8160405282815288868487010111156200028357600080fd5b600093505b82841015620002a7578484018601518185018701529285019262000288565b600086848301015280965050505050505092915050565b600181811c90821680620002d357607f821691505b602082108103620002f457634e487b7160e01b600052602260045260246000fd5b50919050565b601f8211156200034a576000816000526020600020601f850160051c81016020861015620003255750805b601f850160051c820191505b81811015620003465782815560010162000331565b5050505b505050565b81516001600160401b038111156200036b576200036b620001d3565b62000383816200037c8454620002be565b84620002fa565b602080601f831160018114620003bb5760008415620003a25750858301515b600019600386901b1c1916600185901b17855562000346565b600085815260208120601f198616915b82811015620003ec57888601518255948401946001909101908401620003cb565b50858210156200040b5787850151600019600388901b60f8161c191681555b5050505050600190811b01905550565b611ef3806200042b6000396000f3fe608060405234801561001057600080fd5b50600436106101da5760003560e01c806355f804b311610104578063a217fddf116100a2578063d539139311610071578063d5391393146103ff578063d547741f14610426578063e985e9c514610439578063ec87621c1461047557600080fd5b8063a217fddf146103be578063a22cb465146103c6578063b88d4fde146103d9578063c87b56dd146103ec57600080fd5b806370a08231116100de57806370a08231146103625780638456cb591461037557806391d148541461037d57806395d89b41146103b657600080fd5b806355f804b3146103315780635c975abb146103445780636352211e1461034f57600080fd5b80632f2ff15d1161017c57806340d097c31161014b57806340d097c3146102e557806342842e0e146102f857806342966c681461030b5780634f6ccce71461031e57600080fd5b80632f2ff15d146102a45780632f745c59146102b757806336568abe146102ca5780633f4ba83a146102dd57600080fd5b8063095ea7b3116101b8578063095ea7b31461024757806318160ddd1461025c57806323b872dd1461026e578063248a9ca31461028157600080fd5b806301ffc9a7146101df57806306fdde0314610207578063081812fc1461021c575b600080fd5b6101f26101ed36600461196a565b61049c565b60405190151581526020015b60405180910390f35b61020f6104ad565b6040516101fe91906119d7565b61022f61022a3660046119ea565b61053f565b6040516001600160a01b0390911681526020016101fe565b61025a610255366004611a1f565b610568565b005b6008545b6040519081526020016101fe565b61025a61027c366004611a49565b610577565b61026061028f3660046119ea565b6000908152600c602052604090206001015490565b61025a6102b2366004611a85565b610620565b6102606102c5366004611a1f565b610645565b61025a6102d8366004611a85565b6106aa565b61025a6106fb565b6102606102f3366004611ab1565b610730565b61025a610306366004611a49565b6107a0565b61025a6103193660046119ea565b6107bb565b61026061032c3660046119ea565b6107c7565b61025a61033f366004611b58565b610820565b600b5460ff166101f2565b61022f61035d3660046119ea565b610856565b610260610370366004611ab1565b610861565b61025a6108c2565b6101f261038b366004611a85565b6000918252600c602090815260408084206001600160a01b0393909316845291905290205460ff1690565b61020f6108f4565b610260600081565b61025a6103d4366004611ba1565b610903565b61025a6103e7366004611bdd565b61090e565b61020f6103fa3660046119ea565b610925565b6102607f9f2df0fed2c77648de5860a4cc508cd0818c85b8b8a1ab4ceeef8d981c8956a681565b61025a610434366004611a85565b610930565b6101f2610447366004611c59565b6001600160a01b03918216600090815260056020908152604080832093909416825291909152205460ff1690565b6102607f241ecf16d79d0f8dbfb92cbc07fe17840425976cf0667f022fe9877caa831b0881565b60006104a782610955565b92915050565b6060600080546104bc90611c83565b80601f01602080910402602001604051908101604052809291908181526020018280546104e890611c83565b80156105355780601f1061050a57610100808354040283529160200191610535565b820191906000526020600020905b81548152906001019060200180831161051857829003601f168201915b5050505050905090565b600061054a82610993565b506000828152600460205260409020546001600160a01b03166104a7565b6105738282336109cc565b5050565b6001600160a01b0382166105a657604051633250574960e11b8152600060048201526024015b60405180910390fd5b60006105b38383336109d9565b9050836001600160a01b0316816001600160a01b03161461061a576040517f64283d7b0000000000000000000000000000000000000000000000000000000081526001600160a01b038086166004830152602482018490528216604482015260640161059d565b50505050565b6000828152600c602052604090206001015461063b816109ee565b61061a83836109f8565b600061065083610861565b82106106815760405163295f44f760e21b81526001600160a01b03841660048201526024810183905260440161059d565b506001600160a01b03919091166000908152600660209081526040808320938352929052205490565b6001600160a01b03811633146106ec576040517f6697b23200000000000000000000000000000000000000000000000000000000815260040160405180910390fd5b6106f68282610aa6565b505050565b7f241ecf16d79d0f8dbfb92cbc07fe17840425976cf0667f022fe9877caa831b08610725816109ee565b61072d610b2d565b50565b60007f9f2df0fed2c77648de5860a4cc508cd0818c85b8b8a1ab4ceeef8d981c8956a661075c816109ee565b610764610b7f565b600d80546000918261077583611ccd565b9190505590506107858482610bbe565b6107978161079283610bd8565b610c78565b91505b50919050565b6106f68383836040518060200160405280600081525061090e565b610573600082336109d9565b60006107d260085490565b82106107fb5760405163295f44f760e21b8152600060048201526024810183905260440161059d565b6008828154811061080e5761080e611ce6565b90600052602060002001549050919050565b7f241ecf16d79d0f8dbfb92cbc07fe17840425976cf0667f022fe9877caa831b0861084a816109ee565b600e6106f68382611d4c565b60006104a782610993565b60006001600160a01b0382166108a6576040517f89c62b640000000000000000000000000000000000000000000000000000000081526000600482015260240161059d565b506001600160a01b031660009081526003602052604090205490565b7f241ecf16d79d0f8dbfb92cbc07fe17840425976cf0667f022fe9877caa831b086108ec816109ee565b61072d610cc8565b6060600180546104bc90611c83565b610573338383610d05565b610919848484610577565b61061a84848484610dbd565b60606104a782610ee6565b6000828152600c602052604090206001015461094b816109ee565b61061a8383610aa6565b60006001600160e01b031982167f7965db0b0000000000000000000000000000000000000000000000000000000014806104a757506104a782610fe2565b6000818152600260205260408120546001600160a01b0316806104a757604051637e27328960e01b81526004810184905260240161059d565b6106f68383836001611020565b60006109e684848461116b565b949350505050565b61072d8133611180565b6000828152600c602090815260408083206001600160a01b038516845290915281205460ff16610a9e576000838152600c602090815260408083206001600160a01b03861684529091529020805460ff19166001179055610a563390565b6001600160a01b0316826001600160a01b0316847f2f8788117e7eff1d82e926ec794901d17c78024a50270940304540a733656f0d60405160405180910390a45060016104a7565b5060006104a7565b6000828152600c602090815260408083206001600160a01b038516845290915281205460ff1615610a9e576000838152600c602090815260408083206001600160a01b0386168085529252808320805460ff1916905551339286917ff6391f5c32d9c69d2a47ea670b442974b53935d1edc7fd64eb21e047a839171b9190a45060016104a7565b610b356111ee565b600b805460ff191690557f5db9ee0a495bf2e6ff9c91a7834c1ba4fdd244a5e8aa4e537bd38aeae4b073aa335b6040516001600160a01b03909116815260200160405180910390a1565b600b5460ff1615610bbc576040517fd93c066500000000000000000000000000000000000000000000000000000000815260040160405180910390fd5b565b61057382826040518060200160405280600081525061122a565b60606000610be583611241565b600101905060008167ffffffffffffffff811115610c0557610c05611acc565b6040519080825280601f01601f191660200182016040528015610c2f576020820181803683370190505b5090508181016020015b600019017f3031323334353637383961626364656600000000000000000000000000000000600a86061a8153600a8504945084610c3957509392505050565b6000828152600a60205260409020610c908282611d4c565b506040518281527ff8e1a15aba9398e019f0b49df1a4fde98ee17ae345cb5f6b5e2c27f5033e8ce79060200160405180910390a15050565b610cd0610b7f565b600b805460ff191660011790557f62e78cea01bee320cd4e420270b5ea74000d11b0c9f74754ebdbfc544b05a258610b623390565b6001600160a01b038216610d50576040517f5b08ba180000000000000000000000000000000000000000000000000000000081526001600160a01b038316600482015260240161059d565b6001600160a01b03838116600081815260056020908152604080832094871680845294825291829020805460ff191686151590811790915591519182527f17307eab39ab6107e8899845ad3d59bd9653f200f220920489ca2b5937696c31910160405180910390a3505050565b6001600160a01b0383163b1561061a57604051630a85bd0160e11b81526001600160a01b0384169063150b7a0290610dff903390889087908790600401611e0c565b6020604051808303816000875af1925050508015610e3a575060408051601f3d908101601f19168201909252610e3791810190611e48565b60015b610ea3573d808015610e68576040519150601f19603f3d011682016040523d82523d6000602084013e610e6d565b606091505b508051600003610e9b57604051633250574960e11b81526001600160a01b038516600482015260240161059d565b805181602001fd5b6001600160e01b03198116630a85bd0160e11b14610edf57604051633250574960e11b81526001600160a01b038516600482015260240161059d565b5050505050565b6060610ef182610993565b506000828152600a602052604081208054610f0b90611c83565b80601f0160208091040260200160405190810160405280929190818152602001828054610f3790611c83565b8015610f845780601f10610f5957610100808354040283529160200191610f84565b820191906000526020600020905b815481529060010190602001808311610f6757829003601f168201915b505050505090506000610f95611323565b90508051600003610fa7575092915050565b815115610fd9578082604051602001610fc1929190611e65565b60405160208183030381529060405292505050919050565b6109e684611332565b60006001600160e01b031982167f490649060000000000000000000000000000000000000000000000000000000014806104a757506104a78261139a565b808061103457506001600160a01b03821615155b1561112e57600061104484610993565b90506001600160a01b038316158015906110705750826001600160a01b0316816001600160a01b031614155b80156110a257506001600160a01b0380821660009081526005602090815260408083209387168352929052205460ff16155b156110e4576040517fa9fbf51f0000000000000000000000000000000000000000000000000000000081526001600160a01b038416600482015260240161059d565b811561112c5783856001600160a01b0316826001600160a01b03167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b92560405160405180910390a45b505b50506000908152600460205260409020805473ffffffffffffffffffffffffffffffffffffffff19166001600160a01b0392909216919091179055565b6000611175610b7f565b6109e68484846113d8565b6000828152600c602090815260408083206001600160a01b038516845290915290205460ff16610573576040517fe2517d3f0000000000000000000000000000000000000000000000000000000081526001600160a01b03821660048201526024810183905260440161059d565b600b5460ff16610bbc576040517f8dfc202b00000000000000000000000000000000000000000000000000000000815260040160405180910390fd5b61123483836114a5565b6106f66000848484610dbd565b6000807a184f03e93ff9f4daa797ed6e38ed64bf6a1f010000000000000000831061128a577a184f03e93ff9f4daa797ed6e38ed64bf6a1f010000000000000000830492506040015b6d04ee2d6d415b85acef810000000083106112b6576d04ee2d6d415b85acef8100000000830492506020015b662386f26fc1000083106112d457662386f26fc10000830492506010015b6305f5e10083106112ec576305f5e100830492506008015b612710831061130057612710830492506004015b60648310611312576064830492506002015b600a83106104a75760010192915050565b6060600e80546104bc90611c83565b606061133d82610993565b506000611348611323565b905060008151116113685760405180602001604052806000815250611393565b8061137284610bd8565b604051602001611383929190611e65565b6040516020818303038152906040525b9392505050565b60006001600160e01b031982167f780e9d630000000000000000000000000000000000000000000000000000000014806104a757506104a782611523565b6000806113e68585856115be565b90506001600160a01b0381166114435761143e84600880546000838152600960205260408120829055600182018355919091527ff3f7a9fe364faab93b216da50a3214154f22a0a2b415b23a84c8169e8b636ee30155565b611466565b846001600160a01b0316816001600160a01b0316146114665761146681856116c4565b6001600160a01b0385166114825761147d84611755565b6109e6565b846001600160a01b0316816001600160a01b0316146109e6576109e68585611804565b6001600160a01b0382166114cf57604051633250574960e11b81526000600482015260240161059d565b60006114dd838360006109d9565b90506001600160a01b038116156106f6576040517f73c6ac6e0000000000000000000000000000000000000000000000000000000081526000600482015260240161059d565b60006001600160e01b031982167f80ac58cd00000000000000000000000000000000000000000000000000000000148061158657506001600160e01b031982167f5b5e139f00000000000000000000000000000000000000000000000000000000145b806104a757507f01ffc9a7000000000000000000000000000000000000000000000000000000006001600160e01b03198316146104a7565b6000828152600260205260408120546001600160a01b03908116908316156115eb576115eb818486611854565b6001600160a01b0381161561162957611608600085600080611020565b6001600160a01b038116600090815260036020526040902080546000190190555b6001600160a01b03851615611658576001600160a01b0385166000908152600360205260409020805460010190555b600084815260026020526040808220805473ffffffffffffffffffffffffffffffffffffffff19166001600160a01b0389811691821790925591518793918516917fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef91a4949350505050565b60006116cf83610861565b600083815260076020526040902054909150808214611722576001600160a01b03841660009081526006602090815260408083208584528252808320548484528184208190558352600790915290208190555b5060009182526007602090815260408084208490556001600160a01b039094168352600681528383209183525290812055565b60085460009061176790600190611e94565b6000838152600960205260408120546008805493945090928490811061178f5761178f611ce6565b9060005260206000200154905080600883815481106117b0576117b0611ce6565b60009182526020808320909101929092558281526009909152604080822084905585825281205560088054806117e8576117e8611ea7565b6001900381819060005260206000200160009055905550505050565b6000600161181184610861565b61181b9190611e94565b6001600160a01b039093166000908152600660209081526040808320868452825280832085905593825260079052919091209190915550565b61185f8383836118d1565b6106f6576001600160a01b03831661188d57604051637e27328960e01b81526004810182905260240161059d565b6040517f177e802f0000000000000000000000000000000000000000000000000000000081526001600160a01b03831660048201526024810182905260440161059d565b60006001600160a01b038316158015906109e65750826001600160a01b0316846001600160a01b0316148061192b57506001600160a01b0380851660009081526005602090815260408083209387168352929052205460ff165b806109e65750506000908152600460205260409020546001600160a01b03908116911614919050565b6001600160e01b03198116811461072d57600080fd5b60006020828403121561197c57600080fd5b813561139381611954565b60005b838110156119a257818101518382015260200161198a565b50506000910152565b600081518084526119c3816020860160208601611987565b601f01601f19169290920160200192915050565b60208152600061139360208301846119ab565b6000602082840312156119fc57600080fd5b5035919050565b80356001600160a01b0381168114611a1a57600080fd5b919050565b60008060408385031215611a3257600080fd5b611a3b83611a03565b946020939093013593505050565b600080600060608486031215611a5e57600080fd5b611a6784611a03565b9250611a7560208501611a03565b9150604084013590509250925092565b60008060408385031215611a9857600080fd5b82359150611aa860208401611a03565b90509250929050565b600060208284031215611ac357600080fd5b61139382611a03565b634e487b7160e01b600052604160045260246000fd5b600067ffffffffffffffff80841115611afd57611afd611acc565b604051601f8501601f19908116603f01168101908282118183101715611b2557611b25611acc565b81604052809350858152868686011115611b3e57600080fd5b858560208301376000602087830101525050509392505050565b600060208284031215611b6a57600080fd5b813567ffffffffffffffff811115611b8157600080fd5b8201601f81018413611b9257600080fd5b6109e684823560208401611ae2565b60008060408385031215611bb457600080fd5b611bbd83611a03565b915060208301358015158114611bd257600080fd5b809150509250929050565b60008060008060808587031215611bf357600080fd5b611bfc85611a03565b9350611c0a60208601611a03565b925060408501359150606085013567ffffffffffffffff811115611c2d57600080fd5b8501601f81018713611c3e57600080fd5b611c4d87823560208401611ae2565b91505092959194509250565b60008060408385031215611c6c57600080fd5b611c7583611a03565b9150611aa860208401611a03565b600181811c90821680611c9757607f821691505b60208210810361079a57634e487b7160e01b600052602260045260246000fd5b634e487b7160e01b600052601160045260246000fd5b600060018201611cdf57611cdf611cb7565b5060010190565b634e487b7160e01b600052603260045260246000fd5b601f8211156106f6576000816000526020600020601f850160051c81016020861015611d255750805b601f850160051c820191505b81811015611d4457828155600101611d31565b505050505050565b815167ffffffffffffffff811115611d6657611d66611acc565b611d7a81611d748454611c83565b84611cfc565b602080601f831160018114611daf5760008415611d975750858301515b600019600386901b1c1916600185901b178555611d44565b600085815260208120601f198616915b82811015611dde57888601518255948401946001909101908401611dbf565b5085821015611dfc5787850151600019600388901b60f8161c191681555b5050505050600190811b01905550565b60006001600160a01b03808716835280861660208401525083604083015260806060830152611e3e60808301846119ab565b9695505050505050565b600060208284031215611e5a57600080fd5b815161139381611954565b60008351611e77818460208801611987565b835190830190611e8b818360208801611987565b01949350505050565b818103818111156104a7576104a7611cb7565b634e487b7160e01b600052603160045260246000fdfea26469706673582212203ba64e88f697b5f4b32285a3c9c148f2c58317174a7ca67e78e3220f2748aba864736f6c63430008180033";

    private static String librariesLinkedBinary;

    public static final String FUNC_DEFAULT_ADMIN_ROLE = "DEFAULT_ADMIN_ROLE";

    public static final String FUNC_MANAGER_ROLE = "MANAGER_ROLE";

    public static final String FUNC_MINTER_ROLE = "MINTER_ROLE";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_BURN = "burn";

    public static final String FUNC_GETAPPROVED = "getApproved";

    public static final String FUNC_GETROLEADMIN = "getRoleAdmin";

    public static final String FUNC_GRANTROLE = "grantRole";

    public static final String FUNC_HASROLE = "hasRole";

    public static final String FUNC_ISAPPROVEDFORALL = "isApprovedForAll";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_OWNEROF = "ownerOf";

    public static final String FUNC_PAUSE = "pause";

    public static final String FUNC_PAUSED = "paused";

    public static final String FUNC_RENOUNCEROLE = "renounceRole";

    public static final String FUNC_REVOKEROLE = "revokeRole";

    public static final String FUNC_SAFEMINT = "safeMint";

    public static final String FUNC_safeTransferFrom = "safeTransferFrom";

    public static final String FUNC_SETAPPROVALFORALL = "setApprovalForAll";

    public static final String FUNC_SETBASEURI = "setBaseURI";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TOKENBYINDEX = "tokenByIndex";

    public static final String FUNC_TOKENOFOWNERBYINDEX = "tokenOfOwnerByIndex";

    public static final String FUNC_TOKENURI = "tokenURI";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_UNPAUSE = "unpause";

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event APPROVALFORALL_EVENT = new Event("ApprovalForAll", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}));
    ;

    public static final Event BATCHMETADATAUPDATE_EVENT = new Event("BatchMetadataUpdate", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event METADATAUPDATE_EVENT = new Event("MetadataUpdate", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
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

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event UNPAUSED_EVENT = new Event("Unpaused", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected Memento(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Memento(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Memento(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Memento(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<ApprovalEventResponse> getApprovalEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.approved = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static ApprovalEventResponse getApprovalEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(APPROVAL_EVENT, log);
        ApprovalEventResponse typedResponse = new ApprovalEventResponse();
        typedResponse.log = log;
        typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.approved = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getApprovalEventFromLog(log));
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventFlowable(filter);
    }

    public static List<ApprovalForAllEventResponse> getApprovalForAllEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(APPROVALFORALL_EVENT, transactionReceipt);
        ArrayList<ApprovalForAllEventResponse> responses = new ArrayList<ApprovalForAllEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalForAllEventResponse typedResponse = new ApprovalForAllEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.operator = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static ApprovalForAllEventResponse getApprovalForAllEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(APPROVALFORALL_EVENT, log);
        ApprovalForAllEventResponse typedResponse = new ApprovalForAllEventResponse();
        typedResponse.log = log;
        typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.operator = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<ApprovalForAllEventResponse> approvalForAllEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getApprovalForAllEventFromLog(log));
    }

    public Flowable<ApprovalForAllEventResponse> approvalForAllEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVALFORALL_EVENT));
        return approvalForAllEventFlowable(filter);
    }

    public static List<BatchMetadataUpdateEventResponse> getBatchMetadataUpdateEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(BATCHMETADATAUPDATE_EVENT, transactionReceipt);
        ArrayList<BatchMetadataUpdateEventResponse> responses = new ArrayList<BatchMetadataUpdateEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            BatchMetadataUpdateEventResponse typedResponse = new BatchMetadataUpdateEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._fromTokenId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._toTokenId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static BatchMetadataUpdateEventResponse getBatchMetadataUpdateEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(BATCHMETADATAUPDATE_EVENT, log);
        BatchMetadataUpdateEventResponse typedResponse = new BatchMetadataUpdateEventResponse();
        typedResponse.log = log;
        typedResponse._fromTokenId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse._toTokenId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<BatchMetadataUpdateEventResponse> batchMetadataUpdateEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getBatchMetadataUpdateEventFromLog(log));
    }

    public Flowable<BatchMetadataUpdateEventResponse> batchMetadataUpdateEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(BATCHMETADATAUPDATE_EVENT));
        return batchMetadataUpdateEventFlowable(filter);
    }

    public static List<MetadataUpdateEventResponse> getMetadataUpdateEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(METADATAUPDATE_EVENT, transactionReceipt);
        ArrayList<MetadataUpdateEventResponse> responses = new ArrayList<MetadataUpdateEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MetadataUpdateEventResponse typedResponse = new MetadataUpdateEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._tokenId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static MetadataUpdateEventResponse getMetadataUpdateEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(METADATAUPDATE_EVENT, log);
        MetadataUpdateEventResponse typedResponse = new MetadataUpdateEventResponse();
        typedResponse.log = log;
        typedResponse._tokenId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<MetadataUpdateEventResponse> metadataUpdateEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getMetadataUpdateEventFromLog(log));
    }

    public Flowable<MetadataUpdateEventResponse> metadataUpdateEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(METADATAUPDATE_EVENT));
        return metadataUpdateEventFlowable(filter);
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

    public static List<TransferEventResponse> getTransferEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static TransferEventResponse getTransferEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(TRANSFER_EVENT, log);
        TransferEventResponse typedResponse = new TransferEventResponse();
        typedResponse.log = log;
        typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getTransferEventFromLog(log));
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
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

    public RemoteFunctionCall<byte[]> call_MINTER_ROLE() {
        final Function function = new Function(FUNC_MINTER_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_MINTER_ROLE() {
        final Function function = new Function(
                FUNC_MINTER_ROLE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_approve(String to, BigInteger tokenId) {
        final Function function = new Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> call_balanceOf(String owner) {
        final Function function = new Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_balanceOf(String owner) {
        final Function function = new Function(
                FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_burn(BigInteger tokenId) {
        final Function function = new Function(
                FUNC_BURN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> call_getApproved(BigInteger tokenId) {
        final Function function = new Function(FUNC_GETAPPROVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_getApproved(BigInteger tokenId) {
        final Function function = new Function(
                FUNC_GETAPPROVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
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

    public RemoteFunctionCall<Boolean> call_isApprovedForAll(String owner, String operator) {
        final Function function = new Function(FUNC_ISAPPROVEDFORALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner), 
                new org.web3j.abi.datatypes.Address(operator)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_isApprovedForAll(String owner,
            String operator) {
        final Function function = new Function(
                FUNC_ISAPPROVEDFORALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner), 
                new org.web3j.abi.datatypes.Address(operator)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> call_name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_name() {
        final Function function = new Function(
                FUNC_NAME, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> call_ownerOf(BigInteger tokenId) {
        final Function function = new Function(FUNC_OWNEROF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_ownerOf(BigInteger tokenId) {
        final Function function = new Function(
                FUNC_OWNEROF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
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

    public RemoteFunctionCall<TransactionReceipt> send_safeMint(String to) {
        final Function function = new Function(
                FUNC_SAFEMINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> call_safeMint(String to) {
        final Function function = new Function(FUNC_SAFEMINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_safeTransferFrom(String from, String to,
            BigInteger tokenId) {
        final Function function = new Function(
                FUNC_safeTransferFrom, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(from), 
                new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_safeTransferFrom(String from, String to,
            BigInteger tokenId, byte[] data) {
        final Function function = new Function(
                FUNC_safeTransferFrom, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(from), 
                new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_setApprovalForAll(String operator,
            Boolean approved) {
        final Function function = new Function(
                FUNC_SETAPPROVALFORALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(operator), 
                new org.web3j.abi.datatypes.Bool(approved)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_setBaseURI(String baseURI) {
        final Function function = new Function(
                FUNC_SETBASEURI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(baseURI)), 
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

    public RemoteFunctionCall<String> call_symbol() {
        final Function function = new Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_symbol() {
        final Function function = new Function(
                FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> call_tokenByIndex(BigInteger index) {
        final Function function = new Function(FUNC_TOKENBYINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_tokenByIndex(BigInteger index) {
        final Function function = new Function(
                FUNC_TOKENBYINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> call_tokenOfOwnerByIndex(String owner, BigInteger index) {
        final Function function = new Function(FUNC_TOKENOFOWNERBYINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner), 
                new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_tokenOfOwnerByIndex(String owner,
            BigInteger index) {
        final Function function = new Function(
                FUNC_TOKENOFOWNERBYINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner), 
                new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> call_tokenURI(BigInteger tokenId) {
        final Function function = new Function(FUNC_TOKENURI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_tokenURI(BigInteger tokenId) {
        final Function function = new Function(
                FUNC_TOKENURI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> call_totalSupply() {
        final Function function = new Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_totalSupply() {
        final Function function = new Function(
                FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_transferFrom(String from, String to,
            BigInteger tokenId) {
        final Function function = new Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(from), 
                new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
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

    @Deprecated
    public static Memento load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new Memento(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Memento load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Memento(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Memento load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new Memento(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Memento load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Memento(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Memento> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider, String baseURI) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(baseURI)));
        return deployRemoteCall(Memento.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    public static RemoteCall<Memento> deploy(Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider, String baseURI) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(baseURI)));
        return deployRemoteCall(Memento.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Memento> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit, String baseURI) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(baseURI)));
        return deployRemoteCall(Memento.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Memento> deploy(Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit, String baseURI) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(baseURI)));
        return deployRemoteCall(Memento.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
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

    public static class ApprovalEventResponse extends BaseEventResponse {
        public String owner;

        public String approved;

        public BigInteger tokenId;
    }

    public static class ApprovalForAllEventResponse extends BaseEventResponse {
        public String owner;

        public String operator;

        public Boolean approved;
    }

    public static class BatchMetadataUpdateEventResponse extends BaseEventResponse {
        public BigInteger _fromTokenId;

        public BigInteger _toTokenId;
    }

    public static class MetadataUpdateEventResponse extends BaseEventResponse {
        public BigInteger _tokenId;
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

    public static class TransferEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger tokenId;
    }

    public static class UnpausedEventResponse extends BaseEventResponse {
        public String account;
    }
}
