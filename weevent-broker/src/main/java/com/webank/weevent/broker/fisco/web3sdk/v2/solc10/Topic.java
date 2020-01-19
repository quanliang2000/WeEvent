package com.webank.weevent.broker.fisco.web3sdk.v2.solc10;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Bool;
import org.fisco.bcos.web3j.abi.datatypes.DynamicArray;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple1;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
import org.fisco.bcos.web3j.tuples.generated.Tuple3;
import org.fisco.bcos.web3j.tuples.generated.Tuple4;
import org.fisco.bcos.web3j.tuples.generated.Tuple5;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;
import org.fisco.bcos.web3j.tx.txdecode.TransactionDecoder;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class Topic extends Contract {
    public static String BINARY = "608060405234801561001057600080fd5b50611dc4806100206000396000f300608060405260043610610083576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680632b51c66b1461008857806350545d2f146100b1578063a99077f2146100ee578063c10587051461012b578063c4c0836014610168578063fd13b776146101a8578063fdcb0575146101e5575b600080fd5b34801561009457600080fd5b506100af60048036036100aa91908101906118ab565b610223565b005b3480156100bd57600080fd5b506100d860048036036100d391908101906119db565b6104ef565b6040516100e59190611b69565b60405180910390f35b3480156100fa57600080fd5b5061011560048036036101109190810190611a2f565b610602565b6040516101229190611b69565b60405180910390f35b34801561013757600080fd5b50610152600480360361014d91908101906119db565b610853565b60405161015f9190611b69565b60405180910390f35b34801561017457600080fd5b5061018f600480360361018a919081019061199a565b610cce565b60405161019f9493929190611bb4565b60405180910390f35b3480156101b457600080fd5b506101cf60048036036101ca91908101906119db565b610ded565b6040516101dc9190611b4e565b60405180910390f35b3480156101f157600080fd5b5061020c6004803603610207919081019061199a565b610fe2565b60405161021a929190611b84565b60405180910390f35b6000606061022f6114ca565b600092505b87518310156104e557878381518110151561024b57fe5b9060200190602002015191506000826040518082805190602001908083835b60208310151561028f578051825260208201915060208101905060208303925061026a565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020608060405190810160405290816000820154815260200160018201548152602001600282015481526020016003820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152505090508060400151600014156104d857868381518110151561035f57fe5b90602001906020020151816000018181525050858381518110151561038057fe5b9060200190602002015181602001818152505084838151811015156103a157fe5b9060200190602002015181604001818152505083838151811015156103c257fe5b90602001906020020151816060019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff1681525050806000836040518082805190602001908083835b60208310151561043c5780518252602082019150602081019050602083039250610417565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060008201518160000155602082015181600101556040820151816002015560608201518160030160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055509050505b8280600101935050610234565b5050505050505050565b60006104fa836110fa565b151561050b5762018a9890506105fc565b610515838361129b565b156105255762018a9990506105fc565b6001836040518082805190602001908083835b60208310151561055d5780518252602082019150602081019050602083039250610538565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206001018290806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050600090505b92915050565b600061060c6114ca565b610616853261129b565b1515610625576000915061084b565b6000856040518082805190602001908083835b60208310151561065d5780518252602082019150602081019050602083039250610638565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020608060405190810160405290816000820154815260200160018201548152602001600282015481526020016003820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152505090506001816000015101816000018181525050438160200181815250504281604001818152505032816060019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff1681525050806000866040518082805190602001908083835b6020831015156107a85780518252602082019150602081019050602083039250610783565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060008201518160000155602082015181600101556040820151816002015560608201518160030160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550905050806000015191505b509392505050565b600080600080610862866110fa565b15156108735762018a989350610cc5565b61087d868661129b565b151561088e5762018a9a9350610cc5565b6001866040518082805190602001908083835b6020831015156108c657805182526020820191506020810190506020830392506108a1565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020600101805490509250600091505b828210156109fa578473ffffffffffffffffffffffffffffffffffffffff166001876040518082805190602001908083835b60208310151561095e5780518252602082019150602081019050602083039250610939565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020600101838154811015156109a157fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614156109ed576109fa565b8180600101925050610907565b60018303821415610ab5576001866040518082805190602001908083835b602083101515610a3d5780518252602082019150602081019050602083039250610a18565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060010160018403815481101515610a8357fe5b9060005260206000200160006101000a81549073ffffffffffffffffffffffffffffffffffffffff0219169055610c3e565b8190505b60018303811015610c3d576001866040518082805190602001908083835b602083101515610afc5780518252602082019150602081019050602083039250610ad7565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060010160018201815481101515610b4257fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166001876040518082805190602001908083835b602083101515610ba55780518252602082019150602081019050602083039250610b80565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060010182815481101515610be857fe5b9060005260206000200160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508080600101915050610ab9565b5b6001866040518082805190602001908083835b602083101515610c765780518252602082019150602081019050602083039250610c51565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020600101805480919060019003610cbf9190611509565b50600093505b50505092915050565b600080600080610cdc6114ca565b6000866040518082805190602001908083835b602083101515610d145780518252602082019150602081019050602083039250610cef565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020608060405190810160405290816000820154815260200160018201548152602001600282015481526020016003820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681525050905080600001519450806020015193508060400151925080606001519150509193509193565b600080808390806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505060408051908101604052808473ffffffffffffffffffffffffffffffffffffffff16815260200182805480602002602001604051908101604052809291908181526020018280548015610efd57602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019060010190808311610eb3575b50505050508152506001856040518082805190602001908083835b602083101515610f3d5780518252602082019150602081019050602083039250610f18565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506020820151816001019080519060200190610fd3929190611535565b50905050600191505092915050565b6000606060009150610ff3836110fa565b15156110005762018a9891505b6001836040518082805190602001908083835b6020831015156110385780518252602082019150602081019050602083039250611013565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206001018054806020026020016040519081016040528092919081815260200182805480156110ee57602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190600101908083116110a4575b50505050509050915091565b60006111046115bf565b6001836040518082805190602001908083835b60208310151561113c5780518252602082019150602081019050602083039250611117565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206040805190810160405290816000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020016001820180548060200260200160405190810160405280929190818152602001828054801561125557602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001906001019080831161120b575b50505050508152505090503273ffffffffffffffffffffffffffffffffffffffff16816000015173ffffffffffffffffffffffffffffffffffffffff1614915050919050565b60006112a56115bf565b606060006001866040518082805190602001908083835b6020831015156112e157805182526020820191506020810190506020830392506112bc565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206040805190810160405290816000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001600182018054806020026020016040519081016040528092919081815260200182805480156113fa57602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190600101908083116113b0575b50505050508152505092508473ffffffffffffffffffffffffffffffffffffffff16836000015173ffffffffffffffffffffffffffffffffffffffff16141561144657600193506114c1565b82602001519150600090505b81518110156114bc578473ffffffffffffffffffffffffffffffffffffffff16828281518110151561148057fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff1614156114af57600193506114c1565b8080600101915050611452565b600093505b50505092915050565b608060405190810160405280600081526020016000815260200160008152602001600073ffffffffffffffffffffffffffffffffffffffff1681525090565b8154818355818111156115305781836000526020600020918201910161152f91906115ef565b5b505050565b8280548282559060005260206000209081019282156115ae579160200282015b828111156115ad5782518260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555091602001919060010190611555565b5b5090506115bb9190611614565b5090565b6040805190810160405280600073ffffffffffffffffffffffffffffffffffffffff168152602001606081525090565b61161191905b8082111561160d5760008160009055506001016115f5565b5090565b90565b61165491905b8082111561165057600081816101000a81549073ffffffffffffffffffffffffffffffffffffffff02191690555060010161161a565b5090565b90565b60006116638235611d51565b905092915050565b600082601f830112151561167e57600080fd5b813561169161168c82611c26565b611bf9565b915081818352602084019350602081019050838560208402820111156116b657600080fd5b60005b838110156116e657816116cc8882611657565b8452602084019350602083019250506001810190506116b9565b5050505092915050565b600082601f830112151561170357600080fd5b813561171661171182611c4e565b611bf9565b9150818183526020840193506020810190508360005b8381101561175c578135860161174288826117eb565b84526020840193506020830192505060018101905061172c565b5050505092915050565b600082601f830112151561177957600080fd5b813561178c61178782611c76565b611bf9565b915081818352602084019350602081019050838560208402820111156117b157600080fd5b60005b838110156117e157816117c78882611897565b8452602084019350602083019250506001810190506117b4565b5050505092915050565b600082601f83011215156117fe57600080fd5b813561181161180c82611c9e565b611bf9565b9150808252602083016020830185838301111561182d57600080fd5b611838838284611d7b565b50505092915050565b600082601f830112151561185457600080fd5b813561186761186282611cca565b611bf9565b9150808252602083016020830185838301111561188357600080fd5b61188e838284611d7b565b50505092915050565b60006118a38235611d71565b905092915050565b600080600080600060a086880312156118c357600080fd5b600086013567ffffffffffffffff8111156118dd57600080fd5b6118e9888289016116f0565b955050602086013567ffffffffffffffff81111561190657600080fd5b61191288828901611766565b945050604086013567ffffffffffffffff81111561192f57600080fd5b61193b88828901611766565b935050606086013567ffffffffffffffff81111561195857600080fd5b61196488828901611766565b925050608086013567ffffffffffffffff81111561198157600080fd5b61198d8882890161166b565b9150509295509295909350565b6000602082840312156119ac57600080fd5b600082013567ffffffffffffffff8111156119c657600080fd5b6119d284828501611841565b91505092915050565b600080604083850312156119ee57600080fd5b600083013567ffffffffffffffff811115611a0857600080fd5b611a1485828601611841565b9250506020611a2585828601611657565b9150509250929050565b600080600060608486031215611a4457600080fd5b600084013567ffffffffffffffff811115611a5e57600080fd5b611a6a86828701611841565b935050602084013567ffffffffffffffff811115611a8757600080fd5b611a9386828701611841565b925050604084013567ffffffffffffffff811115611ab057600080fd5b611abc86828701611841565b9150509250925092565b611acf81611d1b565b82525050565b6000611ae082611d03565b808452602084019350611af283611cf6565b60005b82811015611b2457611b08868351611ac6565b611b1182611d0e565b9150602086019550600181019050611af5565b50849250505092915050565b611b3981611d3b565b82525050565b611b4881611d47565b82525050565b6000602082019050611b636000830184611b30565b92915050565b6000602082019050611b7e6000830184611b3f565b92915050565b6000604082019050611b996000830185611b3f565b8181036020830152611bab8184611ad5565b90509392505050565b6000608082019050611bc96000830187611b3f565b611bd66020830186611b3f565b611be36040830185611b3f565b611bf06060830184611ac6565b95945050505050565b6000604051905081810181811067ffffffffffffffff82111715611c1c57600080fd5b8060405250919050565b600067ffffffffffffffff821115611c3d57600080fd5b602082029050602081019050919050565b600067ffffffffffffffff821115611c6557600080fd5b602082029050602081019050919050565b600067ffffffffffffffff821115611c8d57600080fd5b602082029050602081019050919050565b600067ffffffffffffffff821115611cb557600080fd5b601f19601f8301169050602081019050919050565b600067ffffffffffffffff821115611ce157600080fd5b601f19601f8301169050602081019050919050565b6000602082019050919050565b600081519050919050565b6000602082019050919050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b60008115159050919050565b6000819050919050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000819050919050565b828183376000838301525050505600a265627a7a72305820eade950cd543f0291421572e07930660a8c8c014681c1989e7d4e377f13704e76c6578706572696d656e74616cf50037";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"topicName\",\"type\":\"string[]\"},{\"name\":\"lastSequence\",\"type\":\"uint256[]\"},{\"name\":\"lastBlock\",\"type\":\"uint256[]\"},{\"name\":\"lastTimestamp\",\"type\":\"uint256[]\"},{\"name\":\"lastSender\",\"type\":\"address[]\"}],\"name\":\"flushSnapshot\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"topicName\",\"type\":\"string\"},{\"name\":\"operatorAddress\",\"type\":\"address\"}],\"name\":\"addOperator\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"topicName\",\"type\":\"string\"},{\"name\":\"eventContent\",\"type\":\"string\"},{\"name\":\"extensions\",\"type\":\"string\"}],\"name\":\"publishWeEvent\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"topicName\",\"type\":\"string\"},{\"name\":\"operatorAddress\",\"type\":\"address\"}],\"name\":\"delOperator\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"topicName\",\"type\":\"string\"}],\"name\":\"getSnapshot\",\"outputs\":[{\"name\":\"lastSequence\",\"type\":\"uint256\"},{\"name\":\"lastBlock\",\"type\":\"uint256\"},{\"name\":\"lastTimestamp\",\"type\":\"uint256\"},{\"name\":\"lastSender\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"topicName\",\"type\":\"string\"},{\"name\":\"ownerAddress\",\"type\":\"address\"}],\"name\":\"addTopicACL\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"topicName\",\"type\":\"string\"}],\"name\":\"listOperator\",\"outputs\":[{\"name\":\"code\",\"type\":\"uint256\"},{\"name\":\"operatorArray\",\"type\":\"address[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"}]";

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_FLUSHSNAPSHOT = "flushSnapshot";

    public static final String FUNC_ADDOPERATOR = "addOperator";

    public static final String FUNC_PUBLISHWEEVENT = "publishWeEvent";

    public static final String FUNC_DELOPERATOR = "delOperator";

    public static final String FUNC_GETSNAPSHOT = "getSnapshot";

    public static final String FUNC_ADDTOPICACL = "addTopicACL";

    public static final String FUNC_LISTOPERATOR = "listOperator";

    @Deprecated
    protected Topic(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Topic(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Topic(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Topic(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<TransactionReceipt> flushSnapshot(List<String> topicName, List<BigInteger> lastSequence, List<BigInteger> lastBlock, List<BigInteger> lastTimestamp, List<String> lastSender) {
        final Function function = new Function(
                FUNC_FLUSHSNAPSHOT,
                Arrays.<Type>asList(topicName.isEmpty() ? org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("string[]") : new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Utf8String>(
                                org.fisco.bcos.web3j.abi.Utils.typeMap(topicName, org.fisco.bcos.web3j.abi.datatypes.Utf8String.class)),
                        lastSequence.isEmpty() ? org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]") : new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                                org.fisco.bcos.web3j.abi.Utils.typeMap(lastSequence, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)),
                        lastBlock.isEmpty() ? org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]") : new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                                org.fisco.bcos.web3j.abi.Utils.typeMap(lastBlock, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)),
                        lastTimestamp.isEmpty() ? org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]") : new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                                org.fisco.bcos.web3j.abi.Utils.typeMap(lastTimestamp, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)),
                        lastSender.isEmpty() ? org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("address[]") : new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Address>(
                                org.fisco.bcos.web3j.abi.Utils.typeMap(lastSender, org.fisco.bcos.web3j.abi.datatypes.Address.class))),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void flushSnapshot(List<String> topicName, List<BigInteger> lastSequence, List<BigInteger> lastBlock, List<BigInteger> lastTimestamp, List<String> lastSender, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_FLUSHSNAPSHOT,
                Arrays.<Type>asList(topicName.isEmpty() ? org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("string[]") : new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Utf8String>(
                                org.fisco.bcos.web3j.abi.Utils.typeMap(topicName, org.fisco.bcos.web3j.abi.datatypes.Utf8String.class)),
                        lastSequence.isEmpty() ? org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]") : new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                                org.fisco.bcos.web3j.abi.Utils.typeMap(lastSequence, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)),
                        lastBlock.isEmpty() ? org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]") : new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                                org.fisco.bcos.web3j.abi.Utils.typeMap(lastBlock, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)),
                        lastTimestamp.isEmpty() ? org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]") : new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                                org.fisco.bcos.web3j.abi.Utils.typeMap(lastTimestamp, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)),
                        lastSender.isEmpty() ? org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("address[]") : new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Address>(
                                org.fisco.bcos.web3j.abi.Utils.typeMap(lastSender, org.fisco.bcos.web3j.abi.datatypes.Address.class))),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String flushSnapshotSeq(List<String> topicName, List<BigInteger> lastSequence, List<BigInteger> lastBlock, List<BigInteger> lastTimestamp, List<String> lastSender) {
        final Function function = new Function(
                FUNC_FLUSHSNAPSHOT,
                Arrays.<Type>asList(topicName.isEmpty() ? org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("string[]") : new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Utf8String>(
                                org.fisco.bcos.web3j.abi.Utils.typeMap(topicName, org.fisco.bcos.web3j.abi.datatypes.Utf8String.class)),
                        lastSequence.isEmpty() ? org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]") : new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                                org.fisco.bcos.web3j.abi.Utils.typeMap(lastSequence, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)),
                        lastBlock.isEmpty() ? org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]") : new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                                org.fisco.bcos.web3j.abi.Utils.typeMap(lastBlock, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)),
                        lastTimestamp.isEmpty() ? org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]") : new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                                org.fisco.bcos.web3j.abi.Utils.typeMap(lastTimestamp, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)),
                        lastSender.isEmpty() ? org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("address[]") : new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Address>(
                                org.fisco.bcos.web3j.abi.Utils.typeMap(lastSender, org.fisco.bcos.web3j.abi.datatypes.Address.class))),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple5<List<String>, List<BigInteger>, List<BigInteger>, List<BigInteger>, List<String>> getFlushSnapshotInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_FLUSHSNAPSHOT,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Utf8String>>() {
                }, new TypeReference<DynamicArray<Uint256>>() {
                }, new TypeReference<DynamicArray<Uint256>>() {
                }, new TypeReference<DynamicArray<Uint256>>() {
                }, new TypeReference<DynamicArray<Address>>() {
                }));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        ;
        return new Tuple5<List<String>, List<BigInteger>, List<BigInteger>, List<BigInteger>, List<String>>(

                convertToNative((List<Utf8String>) results.get(0).getValue()),
                convertToNative((List<Uint256>) results.get(1).getValue()),
                convertToNative((List<Uint256>) results.get(2).getValue()),
                convertToNative((List<Uint256>) results.get(3).getValue()),
                convertToNative((List<Address>) results.get(4).getValue())
        );
    }

    public RemoteCall<TransactionReceipt> addOperator(String topicName, String operatorAddress) {
        final Function function = new Function(
                FUNC_ADDOPERATOR,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(topicName),
                        new org.fisco.bcos.web3j.abi.datatypes.Address(operatorAddress)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void addOperator(String topicName, String operatorAddress, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_ADDOPERATOR,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(topicName),
                        new org.fisco.bcos.web3j.abi.datatypes.Address(operatorAddress)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String addOperatorSeq(String topicName, String operatorAddress) {
        final Function function = new Function(
                FUNC_ADDOPERATOR,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(topicName),
                        new org.fisco.bcos.web3j.abi.datatypes.Address(operatorAddress)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, String> getAddOperatorInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_ADDOPERATOR,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
                }, new TypeReference<Address>() {
                }));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        ;
        return new Tuple2<String, String>(

                (String) results.get(0).getValue(),
                (String) results.get(1).getValue()
        );
    }

    public Tuple1<BigInteger> getAddOperatorOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_ADDOPERATOR,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
                }));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        ;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
        );
    }

    public RemoteCall<TransactionReceipt> publishWeEvent(String topicName, String eventContent, String extensions) {
        final Function function = new Function(
                FUNC_PUBLISHWEEVENT,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(topicName),
                        new org.fisco.bcos.web3j.abi.datatypes.Utf8String(eventContent),
                        new org.fisco.bcos.web3j.abi.datatypes.Utf8String(extensions)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void publishWeEvent(String topicName, String eventContent, String extensions, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_PUBLISHWEEVENT,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(topicName),
                        new org.fisco.bcos.web3j.abi.datatypes.Utf8String(eventContent),
                        new org.fisco.bcos.web3j.abi.datatypes.Utf8String(extensions)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String publishWeEventSeq(String topicName, String eventContent, String extensions) {
        final Function function = new Function(
                FUNC_PUBLISHWEEVENT,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(topicName),
                        new org.fisco.bcos.web3j.abi.datatypes.Utf8String(eventContent),
                        new org.fisco.bcos.web3j.abi.datatypes.Utf8String(extensions)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple3<String, String, String> getPublishWeEventInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_PUBLISHWEEVENT,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
                }, new TypeReference<Utf8String>() {
                }, new TypeReference<Utf8String>() {
                }));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        ;
        return new Tuple3<String, String, String>(

                (String) results.get(0).getValue(),
                (String) results.get(1).getValue(),
                (String) results.get(2).getValue()
        );
    }

    public Tuple1<BigInteger> getPublishWeEventOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_PUBLISHWEEVENT,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
                }));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        ;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
        );
    }

    public RemoteCall<TransactionReceipt> delOperator(String topicName, String operatorAddress) {
        final Function function = new Function(
                FUNC_DELOPERATOR,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(topicName),
                        new org.fisco.bcos.web3j.abi.datatypes.Address(operatorAddress)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void delOperator(String topicName, String operatorAddress, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_DELOPERATOR,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(topicName),
                        new org.fisco.bcos.web3j.abi.datatypes.Address(operatorAddress)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String delOperatorSeq(String topicName, String operatorAddress) {
        final Function function = new Function(
                FUNC_DELOPERATOR,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(topicName),
                        new org.fisco.bcos.web3j.abi.datatypes.Address(operatorAddress)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, String> getDelOperatorInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_DELOPERATOR,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
                }, new TypeReference<Address>() {
                }));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        ;
        return new Tuple2<String, String>(

                (String) results.get(0).getValue(),
                (String) results.get(1).getValue()
        );
    }

    public Tuple1<BigInteger> getDelOperatorOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_DELOPERATOR,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
                }));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        ;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
        );
    }

    public RemoteCall<Tuple4<BigInteger, BigInteger, BigInteger, String>> getSnapshot(String topicName) {
        final Function function = new Function(FUNC_GETSNAPSHOT,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(topicName)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
                }, new TypeReference<Uint256>() {
                }, new TypeReference<Uint256>() {
                }, new TypeReference<Address>() {
                }));
        return new RemoteCall<Tuple4<BigInteger, BigInteger, BigInteger, String>>(
                new Callable<Tuple4<BigInteger, BigInteger, BigInteger, String>>() {
                    @Override
                    public Tuple4<BigInteger, BigInteger, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, BigInteger, BigInteger, String>(
                                (BigInteger) results.get(0).getValue(),
                                (BigInteger) results.get(1).getValue(),
                                (BigInteger) results.get(2).getValue(),
                                (String) results.get(3).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> addTopicACL(String topicName, String ownerAddress) {
        final Function function = new Function(
                FUNC_ADDTOPICACL,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(topicName),
                        new org.fisco.bcos.web3j.abi.datatypes.Address(ownerAddress)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void addTopicACL(String topicName, String ownerAddress, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_ADDTOPICACL,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(topicName),
                        new org.fisco.bcos.web3j.abi.datatypes.Address(ownerAddress)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String addTopicACLSeq(String topicName, String ownerAddress) {
        final Function function = new Function(
                FUNC_ADDTOPICACL,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(topicName),
                        new org.fisco.bcos.web3j.abi.datatypes.Address(ownerAddress)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, String> getAddTopicACLInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_ADDTOPICACL,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
                }, new TypeReference<Address>() {
                }));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        ;
        return new Tuple2<String, String>(

                (String) results.get(0).getValue(),
                (String) results.get(1).getValue()
        );
    }

    public Tuple1<Boolean> getAddTopicACLOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_ADDTOPICACL,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {
                }));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        ;
        return new Tuple1<Boolean>(

                (Boolean) results.get(0).getValue()
        );
    }

    public RemoteCall<Tuple2<BigInteger, List<String>>> listOperator(String topicName) {
        final Function function = new Function(FUNC_LISTOPERATOR,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(topicName)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
                }, new TypeReference<DynamicArray<Address>>() {
                }));
        return new RemoteCall<Tuple2<BigInteger, List<String>>>(
                new Callable<Tuple2<BigInteger, List<String>>>() {
                    @Override
                    public Tuple2<BigInteger, List<String>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<BigInteger, List<String>>(
                                (BigInteger) results.get(0).getValue(),
                                convertToNative((List<Address>) results.get(1).getValue()));
                    }
                });
    }

    @Deprecated
    public static Topic load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Topic(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Topic load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Topic(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Topic load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Topic(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Topic load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Topic(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Topic> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Topic.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Topic> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Topic.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Topic> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Topic.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Topic> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Topic.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
