package contracts.nft.v1;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Array;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.StaticStruct;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Bytes4;
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
import org.web3j.tuples.generated.Tuple4;
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
public class TotemRental extends Contract {
    public static final String BINARY = "0x60a0604052306080523480156200001557600080fd5b506200002062000026565b62000156565b6200003260ff62000035565b50565b60008054610100900460ff1615620000ce578160ff1660011480156200006e57506200006c306200014760201b620012db1760201c565b155b620000c65760405162461bcd60e51b815260206004820152602e60248201526000805160206200264683398151915260448201526d191e481a5b9a5d1a585b1a5e995960921b60648201526084015b60405180910390fd5b506000919050565b60005460ff8084169116106200012d5760405162461bcd60e51b815260206004820152602e60248201526000805160206200264683398151915260448201526d191e481a5b9a5d1a585b1a5e995960921b6064820152608401620000bd565b506000805460ff191660ff92909216919091179055600190565b6001600160a01b03163b151590565b6080516124b86200018e6000396000818161086e015281816108ae01528181610b0601528181610b460152610bd501526124b86000f3fe60806040526004361061019c5760003560e01c80636ba4c138116100ec578063c4d66de81161008a578063e907cf3e11610064578063e907cf3e146104e7578063ec87621c14610529578063f72c0d8b1461054b578063ff0c68891461057f57600080fd5b8063c4d66de814610487578063d547741f146104a7578063e449f341146104c757600080fd5b806391d14854116100c657806391d1485414610411578063a217fddf14610431578063a783f13614610446578063b7c9adbc1461046657600080fd5b80636ba4c1381461038d5780637eed7f69146103ad5780638456cb59146103fc57600080fd5b806336568abe116101595780634e745f1f116101335780634e745f1f1461031d5780634f1ef2861461034d57806352d1902d146103605780635c975abb1461037557600080fd5b806336568abe146102c85780633659cfe6146102e85780633f4ba83a1461030857600080fd5b806301ffc9a7146101a15780630fbf0a93146101d6578063150b7a02146101f8578063248a9ca31461023c5780632bcec4e71461027a5780632f2ff15d146102a8575b600080fd5b3480156101ad57600080fd5b506101c16101bc366004611d0f565b610596565b60405190151581526020015b60405180910390f35b3480156101e257600080fd5b506101f66101f1366004611d39565b6105cd565b005b34801561020457600080fd5b50610223610213366004611e68565b630a85bd0160e11b949350505050565b6040516001600160e01b031990911681526020016101cd565b34801561024857600080fd5b5061026c610257366004611ed0565b60009081526097602052604090206001015490565b6040519081526020016101cd565b34801561028657600080fd5b5061026c610295366004611ee9565b6101936020526000908152604090205481565b3480156102b457600080fd5b506101f66102c3366004611f04565b6107bc565b3480156102d457600080fd5b506101f66102e3366004611f04565b6107e6565b3480156102f457600080fd5b506101f6610303366004611ee9565b610864565b34801561031457600080fd5b506101f6610943565b34801561032957600080fd5b5061033d610338366004611ee9565b610963565b6040516101cd9493929190611f6b565b6101f661035b366004611fb5565b610afc565b34801561036c57600080fd5b5061026c610bc8565b34801561038157600080fd5b5060335460ff166101c1565b34801561039957600080fd5b506101f66103a8366004611d39565b610c7b565b3480156103b957600080fd5b506103e46103c8366004611ed0565b610194602052600090815260409020546001600160a01b031681565b6040516001600160a01b0390911681526020016101cd565b34801561040857600080fd5b506101f6610f3a565b34801561041d57600080fd5b506101c161042c366004611f04565b610f5a565b34801561043d57600080fd5b5061026c600081565b34801561045257600080fd5b506101f6610461366004611ed0565b610f85565b34801561047257600080fd5b50610191546103e4906001600160a01b031681565b34801561049357600080fd5b506101f66104a2366004611ee9565b610fa4565b3480156104b357600080fd5b506101f66104c2366004611f04565b61109a565b3480156104d357600080fd5b506101f66104e2366004611d39565b6110bf565b3480156104f357600080fd5b50610507610502366004612003565b611233565b60408051825181526020808401519082015291810151908201526060016101cd565b34801561053557600080fd5b5061026c60008051602061243c83398151915281565b34801561055757600080fd5b5061026c7f189ab7a9244df0848122154315af71fe140f3db0fe014031783b0946b8c9d2e381565b34801561058b57600080fd5b5061026c6101925481565b60006001600160e01b03198216637965db0b60e01b14806105c757506301ffc9a760e01b6001600160e01b03198316145b92915050565b600261015f54036105f95760405162461bcd60e51b81526004016105f09061202d565b60405180910390fd5b600261015f5560335460ff16156106225760405162461bcd60e51b81526004016105f090612064565b336000908152610193602052604081208054909183919042905b838110156107635760008787838181106106585761065861208e565b61019154602090910292909201359250506001600160a01b03166342842e0e61067e3390565b6040516001600160e01b031960e084901b1681526001600160a01b03909116600482015230602482015260448101849052606401600060405180830381600087803b1580156106cc57600080fd5b505af11580156106e0573d6000803e3d6000fd5b505050506106eb3390565b60008281526101946020908152604080832080546001600160a01b0319166001600160a01b039590951694909417909355868252600289810182528383208581556001818101899055910183905584835289019052208490558361074e816120ba565b945050508061075c906120ba565b905061063c565b50818455336001600160a01b03167fa509148c05da78ccf87e7a40399f2386fb8da73196c9c5daf2b6dd7f2a889a58848888856040516107a69493929190612109565b60405180910390a25050600161015f5550505050565b6000828152609760205260409020600101546107d7816112ea565b6107e183836112f4565b505050565b6001600160a01b03811633146108565760405162461bcd60e51b815260206004820152602f60248201527f416363657373436f6e74726f6c3a2063616e206f6e6c792072656e6f756e636560448201526e103937b632b9903337b91039b2b63360891b60648201526084016105f0565b610860828261137a565b5050565b6001600160a01b037f00000000000000000000000000000000000000000000000000000000000000001630036108ac5760405162461bcd60e51b81526004016105f090612134565b7f00000000000000000000000000000000000000000000000000000000000000006001600160a01b03166108f560008051602061241c833981519152546001600160a01b031690565b6001600160a01b03161461091b5760405162461bcd60e51b81526004016105f090612180565b610924816113e1565b604080516000808252602082019092526109409183919061140b565b50565b60008051602061243c83398151915261095b816112ea565b610940611576565b6001600160a01b0381166000908152610193602052604081205460609081908190848167ffffffffffffffff81111561099e5761099e611dc5565b6040519080825280602002602001820160405280156109c7578160200160208202803683370190505b50905060008267ffffffffffffffff8111156109e5576109e5611dc5565b604051908082528060200260200182016040528015610a0e578160200160208202803683370190505b50905060008367ffffffffffffffff811115610a2c57610a2c611dc5565b604051908082528060200260200182016040528015610a55578160200160208202803683370190505b50905060005b84811015610aec576000610a6f8b83611609565b90508060000151858381518110610a8857610a8861208e565b6020026020010181815250508060200151848381518110610aab57610aab61208e565b6020026020010181815250508060400151838381518110610ace57610ace61208e565b60209081029190910101525080610ae4816120ba565b915050610a5b565b5092989197509550909350915050565b6001600160a01b037f0000000000000000000000000000000000000000000000000000000000000000163003610b445760405162461bcd60e51b81526004016105f090612134565b7f00000000000000000000000000000000000000000000000000000000000000006001600160a01b0316610b8d60008051602061241c833981519152546001600160a01b031690565b6001600160a01b031614610bb35760405162461bcd60e51b81526004016105f090612180565b610bbc826113e1565b6108608282600161140b565b6000306001600160a01b037f00000000000000000000000000000000000000000000000000000000000000001614610c685760405162461bcd60e51b815260206004820152603860248201527f555550535570677261646561626c653a206d757374206e6f742062652063616c60448201527f6c6564207468726f7567682064656c656761746563616c6c000000000000000060648201526084016105f0565b5060008051602061241c83398151915290565b600261015f5403610c9e5760405162461bcd60e51b81526004016105f09061202d565b600261015f5560335460ff1615610cc75760405162461bcd60e51b81526004016105f090612064565b33600090815261019360205260409020805480610ce357600080fd5b8260005b81811015610ee4576000868683818110610d0357610d0361208e565b905060200201359050610d133390565b600082815261019460205260409020546001600160a01b03908116911614610d745760405162461bcd60e51b815260206004820152601460248201527339b437bab632103132903a34329037bbb732b91760611b60448201526064016105f0565b60008181526001860160209081526040808320548084526002808a019093529220015480610dd45760405162461bcd60e51b815260206004820152600d60248201526c1d5b9cdd185ad948199a5c9cdd609a1b60448201526064016105f0565b61019254610de282426121cc565b1015610e305760405162461bcd60e51b815260206004820152601960248201527f636c61696d206e6565647320677261636520706572696f642e0000000000000060448201526064016105f0565b6000838152610194602052604080822080546001600160a01b0319169055610191548151632142170760e11b81523060048201523360248201526044810187905291516001600160a01b03909116926342842e0e926064808201939182900301818387803b158015610ea157600080fd5b505af1158015610eb5573d6000803e3d6000fd5b50505050610ed0878780610ec8906121e3565b9850856116a2565b50505080610edd906120ba565b9050610ce7565b50818355336001600160a01b03167f916f43dce61aa4c4d8761c25ddcacfe178ea96a18f68d2775354bbc06be75aaa828787604051610f25939291906121fa565b60405180910390a25050600161015f55505050565b60008051602061243c833981519152610f52816112ea565b610940611764565b60009182526097602090815260408084206001600160a01b0393909316845291905290205460ff1690565b60008051602061243c833981519152610f9d816112ea565b5061019255565b6000610fb060016117bc565b90508015610fc8576000805461ff0019166101001790555b610fd0611849565b610fd861187a565b610fe061187a565b610feb6000336112f4565b61100360008051602061243c833981519152336112f4565b61102d7f189ab7a9244df0848122154315af71fe140f3db0fe014031783b0946b8c9d2e3336112f4565b61019180546001600160a01b0319166001600160a01b0384161790556202a300610192558015610860576000805461ff0019169055604051600181527f7f26b83ff96e1f2b6a682f133852f6798a09c465da95921460cefb38474024989060200160405180910390a15050565b6000828152609760205260409020600101546110b5816112ea565b6107e1838361137a565b600261015f54036110e25760405162461bcd60e51b81526004016105f09061202d565b600261015f5560335460ff161561110b5760405162461bcd60e51b81526004016105f090612064565b3360009081526101936020526040812090829042905b828110156111e357600086868381811061113d5761113d61208e565b90506020020135905061114d3390565b600082815261019460205260409020546001600160a01b039081169116146111ae5760405162461bcd60e51b815260206004820152601460248201527339b437bab632103132903a34329037bbb732b91760611b60448201526064016105f0565b600090815260018501602090815260408083205483526002808801909252909120018290556111dc816120ba565b9050611121565b50336001600160a01b03167f521525beac28bfef66cd916704ff8044d98f91690a375ce71923320407842a3e8387878561019254876112229190612214565b604051610f2595949392919061222c565b61125760405180606001604052806000815260200160008152602001600081525090565b6001600160a01b0383166000908152610193602090815260408083208584526001019091529020548061128957600080fd5b6001600160a01b03841660009081526101936020908152604080832093835260029384018252918290208251606081018452815481526001820154928101929092529092015490820152905092915050565b6001600160a01b03163b151590565b61094081336118a1565b6112fe8282610f5a565b6108605760008281526097602090815260408083206001600160a01b03851684529091529020805460ff191660011790556113363390565b6001600160a01b0316816001600160a01b0316837f2f8788117e7eff1d82e926ec794901d17c78024a50270940304540a733656f0d60405160405180910390a45050565b6113848282610f5a565b156108605760008281526097602090815260408083206001600160a01b0385168085529252808320805460ff1916905551339285917ff6391f5c32d9c69d2a47ea670b442974b53935d1edc7fd64eb21e047a839171b9190a45050565b7f189ab7a9244df0848122154315af71fe140f3db0fe014031783b0946b8c9d2e3610860816112ea565b7f4910fdfa16fed3260ed0e7147f7cc6da11a60208b5b9406d12a635614ffd91435460ff161561143e576107e183611905565b826001600160a01b03166352d1902d6040518163ffffffff1660e01b8152600401602060405180830381865afa925050508015611498575060408051601f3d908101601f191682019092526114959181019061225a565b60015b6114fb5760405162461bcd60e51b815260206004820152602e60248201527f45524331393637557067726164653a206e657720696d706c656d656e7461746960448201526d6f6e206973206e6f74205555505360901b60648201526084016105f0565b60008051602061241c833981519152811461156a5760405162461bcd60e51b815260206004820152602960248201527f45524331393637557067726164653a20756e737570706f727465642070726f786044820152681a58589b195555525160ba1b60648201526084016105f0565b506107e18383836119a1565b60335460ff166115bf5760405162461bcd60e51b815260206004820152601460248201527314185d5cd8589b194e881b9bdd081c185d5cd95960621b60448201526064016105f0565b6033805460ff191690557f5db9ee0a495bf2e6ff9c91a7834c1ba4fdd244a5e8aa4e537bd38aeae4b073aa335b6040516001600160a01b03909116815260200160405180910390a1565b61162d60405180606001604052806000815260200160008152602001600081525090565b6001600160a01b03831660009081526101936020526040902054821061165257600080fd5b506001600160a01b03919091166000908152610193602090815260408083209383526002938401825291829020825160608101845281548152600182015492810192909252909201549082015290565b60006116af6001846121cc565b600083815260018601602052604090205490915080821461172c57600082815260028087016020818152604080852081516060810183528154808252600180840154838701908152938801548386019081528a8a529686528489209182559251818401559451949095019390935592518452908801905290208190555b506000918252600180850160209081526040808520859055928452600295860190529082208281559081018290559092019190915550565b60335460ff16156117875760405162461bcd60e51b81526004016105f090612064565b6033805460ff191660011790557f62e78cea01bee320cd4e420270b5ea74000d11b0c9f74754ebdbfc544b05a2586115ec3390565b60008054610100900460ff1615611803578160ff1660011480156117df5750303b155b6117fb5760405162461bcd60e51b81526004016105f090612273565b506000919050565b60005460ff80841691161061182a5760405162461bcd60e51b81526004016105f090612273565b506000805460ff191660ff92909216919091179055600190565b919050565b600054610100900460ff166118705760405162461bcd60e51b81526004016105f0906122c1565b6118786119cc565b565b600054610100900460ff166118785760405162461bcd60e51b81526004016105f0906122c1565b6118ab8282610f5a565b610860576118c3816001600160a01b031660146119ff565b6118ce8360206119ff565b6040516020016118df929190612338565b60408051601f198184030181529082905262461bcd60e51b82526105f0916004016123ad565b6001600160a01b0381163b6119725760405162461bcd60e51b815260206004820152602d60248201527f455243313936373a206e657720696d706c656d656e746174696f6e206973206e60448201526c1bdd08184818dbdb9d1c9858dd609a1b60648201526084016105f0565b60008051602061241c83398151915280546001600160a01b0319166001600160a01b0392909216919091179055565b6119aa83611ba2565b6000825111806119b75750805b156107e1576119c68383611be2565b50505050565b600054610100900460ff166119f35760405162461bcd60e51b81526004016105f0906122c1565b6033805460ff19169055565b60606000611a0e8360026123e0565b611a19906002612214565b67ffffffffffffffff811115611a3157611a31611dc5565b6040519080825280601f01601f191660200182016040528015611a5b576020820181803683370190505b509050600360fc1b81600081518110611a7657611a7661208e565b60200101906001600160f81b031916908160001a905350600f60fb1b81600181518110611aa557611aa561208e565b60200101906001600160f81b031916908160001a9053506000611ac98460026123e0565b611ad4906001612214565b90505b6001811115611b4c576f181899199a1a9b1b9c1cb0b131b232b360811b85600f1660108110611b0857611b0861208e565b1a60f81b828281518110611b1e57611b1e61208e565b60200101906001600160f81b031916908160001a90535060049490941c93611b45816121e3565b9050611ad7565b508315611b9b5760405162461bcd60e51b815260206004820181905260248201527f537472696e67733a20686578206c656e67746820696e73756666696369656e7460448201526064016105f0565b9392505050565b611bab81611905565b6040516001600160a01b038216907fbc7cd75a20ee27fd9adebab32041f755214dbc6bffa90cc0225b39da2e5c2d3b90600090a250565b60606001600160a01b0383163b611c4a5760405162461bcd60e51b815260206004820152602660248201527f416464726573733a2064656c65676174652063616c6c20746f206e6f6e2d636f6044820152651b9d1c9858dd60d21b60648201526084016105f0565b600080846001600160a01b031684604051611c6591906123ff565b600060405180830381855af49150503d8060008114611ca0576040519150601f19603f3d011682016040523d82523d6000602084013e611ca5565b606091505b5091509150611ccd828260405180606001604052806027815260200161245c60279139611cd6565b95945050505050565b60608315611ce5575081611b9b565b825115611cf55782518084602001fd5b8160405162461bcd60e51b81526004016105f091906123ad565b600060208284031215611d2157600080fd5b81356001600160e01b031981168114611b9b57600080fd5b60008060208385031215611d4c57600080fd5b823567ffffffffffffffff80821115611d6457600080fd5b818501915085601f830112611d7857600080fd5b813581811115611d8757600080fd5b8660208260051b8501011115611d9c57600080fd5b60209290920196919550909350505050565b80356001600160a01b038116811461184457600080fd5b634e487b7160e01b600052604160045260246000fd5b600082601f830112611dec57600080fd5b813567ffffffffffffffff80821115611e0757611e07611dc5565b604051601f8301601f19908116603f01168101908282118183101715611e2f57611e2f611dc5565b81604052838152866020858801011115611e4857600080fd5b836020870160208301376000602085830101528094505050505092915050565b60008060008060808587031215611e7e57600080fd5b611e8785611dae565b9350611e9560208601611dae565b925060408501359150606085013567ffffffffffffffff811115611eb857600080fd5b611ec487828801611ddb565b91505092959194509250565b600060208284031215611ee257600080fd5b5035919050565b600060208284031215611efb57600080fd5b611b9b82611dae565b60008060408385031215611f1757600080fd5b82359150611f2760208401611dae565b90509250929050565b600081518084526020808501945080840160005b83811015611f6057815187529582019590820190600101611f44565b509495945050505050565b848152608060208201526000611f846080830186611f30565b8281036040840152611f968186611f30565b90508281036060840152611faa8185611f30565b979650505050505050565b60008060408385031215611fc857600080fd5b611fd183611dae565b9150602083013567ffffffffffffffff811115611fed57600080fd5b611ff985828601611ddb565b9150509250929050565b6000806040838503121561201657600080fd5b61201f83611dae565b946020939093013593505050565b6020808252601f908201527f5265656e7472616e637947756172643a207265656e7472616e742063616c6c00604082015260600190565b60208082526010908201526f14185d5cd8589b194e881c185d5cd95960821b604082015260600190565b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052601160045260246000fd5b6000600182016120cc576120cc6120a4565b5060010190565b81835260006001600160fb1b038311156120ec57600080fd5b8260051b8083602087013760009401602001938452509192915050565b8481526060602082015260006121236060830185876120d3565b905082604083015295945050505050565b6020808252602c908201527f46756e6374696f6e206d7573742062652063616c6c6564207468726f7567682060408201526b19195b1959d85d1958d85b1b60a21b606082015260800190565b6020808252602c908201527f46756e6374696f6e206d7573742062652063616c6c6564207468726f7567682060408201526b6163746976652070726f787960a01b606082015260800190565b6000828210156121de576121de6120a4565b500390565b6000816121f2576121f26120a4565b506000190190565b838152604060208201526000611ccd6040830184866120d3565b60008219821115612227576122276120a4565b500190565b8581526080602082015260006122466080830186886120d3565b604083019490945250606001529392505050565b60006020828403121561226c57600080fd5b5051919050565b6020808252602e908201527f496e697469616c697a61626c653a20636f6e747261637420697320616c72656160408201526d191e481a5b9a5d1a585b1a5e995960921b606082015260800190565b6020808252602b908201527f496e697469616c697a61626c653a20636f6e7472616374206973206e6f74206960408201526a6e697469616c697a696e6760a81b606082015260800190565b60005b8381101561232757818101518382015260200161230f565b838111156119c65750506000910152565b7f416363657373436f6e74726f6c3a206163636f756e742000000000000000000081526000835161237081601785016020880161230c565b7001034b99036b4b9b9b4b733903937b6329607d1b60179184019182015283516123a181602884016020880161230c565b01602801949350505050565b60208152600082518060208401526123cc81604085016020870161230c565b601f01601f19169190910160400192915050565b60008160001904831182151516156123fa576123fa6120a4565b500290565b6000825161241181846020870161230c565b919091019291505056fe360894a13ba1a3210667c828492db98dca3e2076cc3735a920a3ca505d382bbc241ecf16d79d0f8dbfb92cbc07fe17840425976cf0667f022fe9877caa831b08416464726573733a206c6f772d6c6576656c2064656c65676174652063616c6c206661696c6564a264697066735822122062c58eb9729a786728c63c83352320c5c57d97c47f3df8e5954efd55a7d9a8ec64736f6c634300080e0033496e697469616c697a61626c653a20636f6e747261637420697320616c726561";

    private static String librariesLinkedBinary;

    public static final String FUNC_DEFAULT_ADMIN_ROLE = "DEFAULT_ADMIN_ROLE";

    public static final String FUNC_MANAGER_ROLE = "MANAGER_ROLE";

    public static final String FUNC_UPGRADER_ROLE = "UPGRADER_ROLE";

    public static final String FUNC__CLAIMGRACEPERIODSECOND = "_claimGracePeriodSecond";

    public static final String FUNC__STAKERADDRESSBYTOTEMID = "_stakerAddressByTotemId";

    public static final String FUNC__STAKERBYADDRESS = "_stakerByAddress";

    public static final String FUNC__TOTEM = "_totem";

    public static final String FUNC_GETROLEADMIN = "getRoleAdmin";

    public static final String FUNC_GRANTROLE = "grantRole";

    public static final String FUNC_HASROLE = "hasRole";

    public static final String FUNC_ONERC721RECEIVED = "onERC721Received";

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

    public static final String FUNC_SETCLAIMGRACEPERIODSECOND = "setClaimGracePeriodSecond";

    public static final String FUNC_STAKE = "stake";

    public static final String FUNC_UNSTAKE = "unstake";

    public static final String FUNC_CLAIM = "claim";

    public static final String FUNC_STAKEDTOTEMBYTOTEMID = "stakedTotemByTotemId";

    public static final String FUNC_STAKERINFO = "stakerInfo";

    public static final Event ADMINCHANGED_EVENT = new Event("AdminChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event BEACONUPGRADED_EVENT = new Event("BeaconUpgraded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event CLAIM_EVENT = new Event("Claim", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicArray<Uint256>>() {}));
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

    public static final Event STAKE_EVENT = new Event("Stake", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event UNPAUSED_EVENT = new Event("Unpaused", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event UNSTAKE_EVENT = new Event("Unstake", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event UPGRADED_EVENT = new Event("Upgraded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("1677429376372", "0xF8f22CDF6FDC524f018db20435476B04EcC3BF83");
        _addresses.put("56", "0x055695bE82229dA0d2e8fA17A78AC1a1170251E1");
        _addresses.put("80001", "0x117c4a16360aD21C62518D933dcfa497E8eCf12b");
        _addresses.put("1662908282481", "0xA586074FA4Fe3E546A132a16238abe37951D41fE");
        _addresses.put("137", "0x940648c77E1a282e5D814869c6c301598777E5CC");
        _addresses.put("19011", "0x496ceE13203d22A060D5E0b97F75E5C39E556ee4");
        _addresses.put("40875", "0x5EA92Fe836DdEfd4F5A6dB6D2012b3F1C1c3dD6F");
        _addresses.put("97", "0x98d91bB259DF8889b51fa703d73743eF36c81aD1");
    }

    @Deprecated
    protected TotemRental(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TotemRental(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TotemRental(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TotemRental(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public static List<ClaimEventResponse> getClaimEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(CLAIM_EVENT, transactionReceipt);
        ArrayList<ClaimEventResponse> responses = new ArrayList<ClaimEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ClaimEventResponse typedResponse = new ClaimEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.staker = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.totemIds = (List<BigInteger>) ((Array) eventValues.getNonIndexedValues().get(1)).getNativeValueCopy();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static ClaimEventResponse getClaimEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(CLAIM_EVENT, log);
        ClaimEventResponse typedResponse = new ClaimEventResponse();
        typedResponse.log = log;
        typedResponse.staker = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.totemIds = (List<BigInteger>) ((Array) eventValues.getNonIndexedValues().get(1)).getNativeValueCopy();
        return typedResponse;
    }

    public Flowable<ClaimEventResponse> claimEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getClaimEventFromLog(log));
    }

    public Flowable<ClaimEventResponse> claimEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CLAIM_EVENT));
        return claimEventFlowable(filter);
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

    public static List<StakeEventResponse> getStakeEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(STAKE_EVENT, transactionReceipt);
        ArrayList<StakeEventResponse> responses = new ArrayList<StakeEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            StakeEventResponse typedResponse = new StakeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.staker = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.totemIds = (List<BigInteger>) ((Array) eventValues.getNonIndexedValues().get(1)).getNativeValueCopy();
            typedResponse.staked = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static StakeEventResponse getStakeEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(STAKE_EVENT, log);
        StakeEventResponse typedResponse = new StakeEventResponse();
        typedResponse.log = log;
        typedResponse.staker = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.totemIds = (List<BigInteger>) ((Array) eventValues.getNonIndexedValues().get(1)).getNativeValueCopy();
        typedResponse.staked = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<StakeEventResponse> stakeEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getStakeEventFromLog(log));
    }

    public Flowable<StakeEventResponse> stakeEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(STAKE_EVENT));
        return stakeEventFlowable(filter);
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

    public static List<UnstakeEventResponse> getUnstakeEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(UNSTAKE_EVENT, transactionReceipt);
        ArrayList<UnstakeEventResponse> responses = new ArrayList<UnstakeEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            UnstakeEventResponse typedResponse = new UnstakeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.staker = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.totemIds = (List<BigInteger>) ((Array) eventValues.getNonIndexedValues().get(1)).getNativeValueCopy();
            typedResponse.unstaked = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.claimable = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static UnstakeEventResponse getUnstakeEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(UNSTAKE_EVENT, log);
        UnstakeEventResponse typedResponse = new UnstakeEventResponse();
        typedResponse.log = log;
        typedResponse.staker = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.totemIds = (List<BigInteger>) ((Array) eventValues.getNonIndexedValues().get(1)).getNativeValueCopy();
        typedResponse.unstaked = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
        typedResponse.claimable = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
        return typedResponse;
    }

    public Flowable<UnstakeEventResponse> unstakeEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getUnstakeEventFromLog(log));
    }

    public Flowable<UnstakeEventResponse> unstakeEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(UNSTAKE_EVENT));
        return unstakeEventFlowable(filter);
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

    public RemoteFunctionCall<BigInteger> call__claimGracePeriodSecond() {
        final Function function = new Function(FUNC__CLAIMGRACEPERIODSECOND, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send__claimGracePeriodSecond() {
        final Function function = new Function(
                FUNC__CLAIMGRACEPERIODSECOND, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> call__stakerAddressByTotemId(BigInteger param0) {
        final Function function = new Function(FUNC__STAKERADDRESSBYTOTEMID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send__stakerAddressByTotemId(BigInteger param0) {
        final Function function = new Function(
                FUNC__STAKERADDRESSBYTOTEMID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> call__stakerByAddress(String param0) {
        final Function function = new Function(FUNC__STAKERBYADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send__stakerByAddress(String param0) {
        final Function function = new Function(
                FUNC__STAKERBYADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> call__totem() {
        final Function function = new Function(FUNC__TOTEM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send__totem() {
        final Function function = new Function(
                FUNC__TOTEM, 
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

    public RemoteFunctionCall<TransactionReceipt> send_onERC721Received(String param0,
            String param1, BigInteger param2, byte[] param3) {
        final Function function = new Function(
                FUNC_ONERC721RECEIVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.Address(param1), 
                new org.web3j.abi.datatypes.generated.Uint256(param2), 
                new org.web3j.abi.datatypes.DynamicBytes(param3)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<byte[]> call_onERC721Received(String param0, String param1,
            BigInteger param2, byte[] param3) {
        final Function function = new Function(FUNC_ONERC721RECEIVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.Address(param1), 
                new org.web3j.abi.datatypes.generated.Uint256(param2), 
                new org.web3j.abi.datatypes.DynamicBytes(param3)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes4>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
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

    public RemoteFunctionCall<TransactionReceipt> send_initialize(String totemAddress) {
        final Function function = new Function(
                FUNC_INITIALIZE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(totemAddress)), 
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

    public RemoteFunctionCall<TransactionReceipt> send_setClaimGracePeriodSecond(
            BigInteger gracePeriodSecond) {
        final Function function = new Function(
                FUNC_SETCLAIMGRACEPERIODSECOND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(gracePeriodSecond)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_stake(List<BigInteger> totemIds) {
        final Function function = new Function(
                FUNC_STAKE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(totemIds, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_unstake(List<BigInteger> totemIds) {
        final Function function = new Function(
                FUNC_UNSTAKE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(totemIds, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send_claim(List<BigInteger> totemIds) {
        final Function function = new Function(
                FUNC_CLAIM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(totemIds, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Totem> call_stakedTotemByTotemId(String staker, BigInteger totemId) {
        final Function function = new Function(FUNC_STAKEDTOTEMBYTOTEMID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(staker), 
                new org.web3j.abi.datatypes.generated.Uint256(totemId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Totem>() {}));
        return executeRemoteCallSingleValueReturn(function, Totem.class);
    }

    public RemoteFunctionCall<TransactionReceipt> send_stakedTotemByTotemId(String staker,
            BigInteger totemId) {
        final Function function = new Function(
                FUNC_STAKEDTOTEMBYTOTEMID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(staker), 
                new org.web3j.abi.datatypes.generated.Uint256(totemId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple4<BigInteger, List<BigInteger>, List<BigInteger>, List<BigInteger>>> call_stakerInfo(
            String staker) {
        final Function function = new Function(FUNC_STAKERINFO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(staker)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteFunctionCall<Tuple4<BigInteger, List<BigInteger>, List<BigInteger>, List<BigInteger>>>(function,
                new Callable<Tuple4<BigInteger, List<BigInteger>, List<BigInteger>, List<BigInteger>>>() {
                    @Override
                    public Tuple4<BigInteger, List<BigInteger>, List<BigInteger>, List<BigInteger>> call(
                            ) throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, List<BigInteger>, List<BigInteger>, List<BigInteger>>(
                                (BigInteger) results.get(0).getValue(), 
                                convertToNative((List<Uint256>) results.get(1).getValue()), 
                                convertToNative((List<Uint256>) results.get(2).getValue()), 
                                convertToNative((List<Uint256>) results.get(3).getValue()));
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> send_stakerInfo(String staker) {
        final Function function = new Function(
                FUNC_STAKERINFO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(staker)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static TotemRental load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new TotemRental(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TotemRental load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TotemRental(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TotemRental load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new TotemRental(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TotemRental load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TotemRental(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TotemRental> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TotemRental.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    public static RemoteCall<TotemRental> deploy(Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TotemRental.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<TotemRental> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TotemRental.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<TotemRental> deploy(Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TotemRental.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
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

    public static class Totem extends StaticStruct {
        public BigInteger Id;

        public BigInteger TimeOfStaked;

        public BigInteger TimeOfUnstaked;

        public Totem(BigInteger Id, BigInteger TimeOfStaked, BigInteger TimeOfUnstaked) {
            super(new org.web3j.abi.datatypes.generated.Uint256(Id), 
                    new org.web3j.abi.datatypes.generated.Uint256(TimeOfStaked), 
                    new org.web3j.abi.datatypes.generated.Uint256(TimeOfUnstaked));
            this.Id = Id;
            this.TimeOfStaked = TimeOfStaked;
            this.TimeOfUnstaked = TimeOfUnstaked;
        }

        public Totem(Uint256 Id, Uint256 TimeOfStaked, Uint256 TimeOfUnstaked) {
            super(Id, TimeOfStaked, TimeOfUnstaked);
            this.Id = Id.getValue();
            this.TimeOfStaked = TimeOfStaked.getValue();
            this.TimeOfUnstaked = TimeOfUnstaked.getValue();
        }
    }

    public static class AdminChangedEventResponse extends BaseEventResponse {
        public String previousAdmin;

        public String newAdmin;
    }

    public static class BeaconUpgradedEventResponse extends BaseEventResponse {
        public String beacon;
    }

    public static class ClaimEventResponse extends BaseEventResponse {
        public String staker;

        public BigInteger amount;

        public List<BigInteger> totemIds;
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

    public static class StakeEventResponse extends BaseEventResponse {
        public String staker;

        public BigInteger amount;

        public List<BigInteger> totemIds;

        public BigInteger staked;
    }

    public static class UnpausedEventResponse extends BaseEventResponse {
        public String account;
    }

    public static class UnstakeEventResponse extends BaseEventResponse {
        public String staker;

        public BigInteger amount;

        public List<BigInteger> totemIds;

        public BigInteger unstaked;

        public BigInteger claimable;
    }

    public static class UpgradedEventResponse extends BaseEventResponse {
        public String implementation;
    }
}
