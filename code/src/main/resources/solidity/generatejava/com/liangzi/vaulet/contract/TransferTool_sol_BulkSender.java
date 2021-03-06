package com.liangzi.vaulet.contract;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.2.0.
 */
public class TransferTool_sol_BulkSender extends Contract {
    private static final String BINARY = "6080604052662386f26fc10000600255670de0b6b3a7640000600355336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550611c658061006a6000396000f300608060405260043610610133576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806316fed3e2146101385780631d833aae1461018f5780633d06242a146102125780634a311f4d1461023f5780634c3b8912146102fb578063531ebce51461035e57806355f6e87a146103b557806362b632f41461045157806375c6b74a1461050d5780638279c7db146105a95780638da5cb5b146105ec578063986078fe146106435780639c1f6133146106c6578063aa168b47146106d0578063c8813ffd1461072b578063cf82046114610791578063f05d16f7146107bc578063f0a0a299146107e9578063f2fde38b14610814578063f4201c3c14610857578063f48d11af146108b2578063f8b2cb4f14610918578063feaf653d1461095b575b600080fd5b34801561014457600080fd5b5061014d6109be565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b610210600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190820180359060200190808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050509192919290803590602001909291905050506109e4565b005b34801561021e57600080fd5b5061023d600480360381019080803590602001909291905050506109f4565b005b6102f9600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919291929080359060200190820180359060200190808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050509192919290505050610a59565b005b61035c6004803603810190808035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919291929080359060200190929190505050610a69565b005b34801561036a57600080fd5b50610373610a77565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b61044f6004803603810190808035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919291929080359060200190820180359060200190808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050509192919290505050610b21565b005b61050b600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919291929080359060200190820180359060200190808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050509192919290505050610b2f565b005b6105a76004803603810190808035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919291929080359060200190820180359060200190808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050509192919290505050610b3f565b005b3480156105b557600080fd5b506105ea600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610b4d565b005b3480156105f857600080fd5b50610601610c28565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6106c4600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919291929080359060200190929190505050610c4d565b005b6106ce610c5d565b005b3480156106dc57600080fd5b50610711600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610d15565b604051808215151515815260200191505060405180910390f35b34801561073757600080fd5b5061078f60048036038101908080359060200190820180359060200190808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050509192919290505050610d35565b005b34801561079d57600080fd5b506107a6610e20565b6040518082815260200191505060405180910390f35b3480156107c857600080fd5b506107e760048036038101908080359060200190929190505050610e26565b005b3480156107f557600080fd5b506107fe610e8b565b6040518082815260200191505060405180910390f35b34801561082057600080fd5b50610855600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610e91565b005b34801561086357600080fd5b50610898600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610f66565b604051808215151515815260200191505060405180910390f35b3480156108be57600080fd5b5061091660048036038101908080359060200190820180359060200190808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050509192919290505050611013565b005b34801561092457600080fd5b50610959600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506110fe565b005b6109bc6004803603810190808035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919291929080359060200190929190505050611435565b005b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6109ef838383611443565b505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610a4f57600080fd5b8060038190555050565b610a64838383611650565b505050565b610a738282611874565b5050565b60008073ffffffffffffffffffffffffffffffffffffffff16600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415610af8576000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050610b1e565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690505b90565b610b2b8282611a02565b5050565b610b3a838383611650565b505050565b610b498282611a02565b5050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610ba857600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614151515610be457600080fd5b80600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b610c58838383611443565b505050565b60006003543410151515610c7057600080fd5b610c78610a77565b90508073ffffffffffffffffffffffffffffffffffffffff166108fc349081150290604051600060405180830381858888f193505050501515610cba57600080fd5b6001600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b60046020528060005260406000206000915054906101000a900460ff1681565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610d9257600080fd5b600090505b8151811015610e1c576001600460008484815181101515610db457fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055508080600101915050610d97565b5050565b60025481565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610e8157600080fd5b8060028190555050565b60035481565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610eec57600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16141515610f6357806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b50565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff16148061100c5750600460008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff165b9050919050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561107057600080fd5b600090505b81518110156110fa57600060046000848481518110151561109257fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055508080600101915050611075565b5050565b60008060008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561115e57600080fd5b611166610a77565b9250600073ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff1614156111f9578273ffffffffffffffffffffffffffffffffffffffff166108fc3073ffffffffffffffffffffffffffffffffffffffff16319081150290604051600060405180830381858888f1935050505015156111f457600080fd5b61142f565b8391508173ffffffffffffffffffffffffffffffffffffffff166370a08231306040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15801561129757600080fd5b505af11580156112ab573d6000803e3d6000fd5b505050506040513d60208110156112c157600080fd5b810190808051906020019092919050505090508173ffffffffffffffffffffffffffffffffffffffff1663a9059cbb84836040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050600060405180830381600087803b15801561137757600080fd5b505af115801561138b573d6000803e3d6000fd5b505050507fc9076fc68f7c8242d2eeb2e0c02b8cafae31bb4fcbe2b89ef1f27846ac6facaf848483604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828152602001935050505060405180910390a15b50505050565b61143f8282611874565b5050565b60008060008060008034955061145833610f66565b945084151561147357600254861015151561147257600080fd5b5b60ff88511115151561148457600080fd5b3393506114ae876114a060018b51611bc690919063ffffffff16565b611be290919063ffffffff16565b9250889150600190505b87518160ff1610156115da578173ffffffffffffffffffffffffffffffffffffffff166323b872dd858a8460ff168151811015156114f257fe5b906020019060200201518a6040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050600060405180830381600087803b1580156115b557600080fd5b505af11580156115c9573d6000803e3d6000fd5b5050505080806001019150506114b8565b7fe4e3577249108daaa0a07e6d9aabc5fef8e89ec09da3f9dccfe7ef215e4efc128984604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390a1505050505050505050565b600080600080600034945061166433610f66565b935083151561167f57600254851015151561167e57600080fd5b5b8551875114151561168f57600080fd5b60ff8751111515156116a057600080fd5b8560008151811015156116af57fe5b906020019060200201519250879150600190505b86518160ff1610156117ff578173ffffffffffffffffffffffffffffffffffffffff166323b872dd33898460ff168151811015156116fd57fe5b90602001906020020151898560ff1681518110151561171857fe5b906020019060200201516040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050600060405180830381600087803b1580156117da57600080fd5b505af11580156117ee573d6000803e3d6000fd5b5050505080806001019150506116c3565b7fe4e3577249108daaa0a07e6d9aabc5fef8e89ec09da3f9dccfe7ef215e4efc128884604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390a15050505050505050565b6000806000806118a18561189360018951611bc690919063ffffffff16565b611be290919063ffffffff16565b93503492506118af33610f66565b915081156118cb578383101515156118c657600080fd5b6118ef565b6118e060025485611c1890919063ffffffff16565b83101515156118ee57600080fd5b5b60ff86511115151561190057600080fd5b600190505b85518160ff16101561198d576119248584611bc690919063ffffffff16565b9250858160ff1681518110151561193757fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff166108fc869081150290604051600060405180830381858888f19350505050151561198057600080fd5b8080600101915050611905565b7fe4e3577249108daaa0a07e6d9aabc5fef8e89ec09da3f9dccfe7ef215e4efc1261beef34604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390a1505050505050565b600080600080846000815181101515611a1757fe5b906020019060200201519350349250611a2f33610f66565b91508115611a4b57838310151515611a4657600080fd5b611a6f565b611a6060025485611c1890919063ffffffff16565b8310151515611a6e57600080fd5b5b84518651141515611a7f57600080fd5b60ff865111151515611a9057600080fd5b600190505b85518160ff161015611b5157611ace858260ff16815181101515611ab557fe5b9060200190602002015184611bc690919063ffffffff16565b9250858160ff16815181101515611ae157fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff166108fc868360ff16815181101515611b1557fe5b906020019060200201519081150290604051600060405180830381858888f193505050501515611b4457600080fd5b8080600101915050611a95565b7fe4e3577249108daaa0a07e6d9aabc5fef8e89ec09da3f9dccfe7ef215e4efc1261beef34604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390a1505050505050565b6000828211151515611bd757600080fd5b818303905092915050565b60008082840290506000841480611c035750828482811515611c0057fe5b04145b1515611c0e57600080fd5b8091505092915050565b6000808284019050838110151515611c2f57600080fd5b80915050929150505600a165627a7a723058207e12fd820f2ea3e1a627a81765472b45f25a555fb26ba9309f4ae77b1cdfbab80029";

    protected TransferTool_sol_BulkSender(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TransferTool_sol_BulkSender(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<LogTokenBulkSentEventResponse> getLogTokenBulkSentEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("LogTokenBulkSent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<LogTokenBulkSentEventResponse> responses = new ArrayList<LogTokenBulkSentEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            LogTokenBulkSentEventResponse typedResponse = new LogTokenBulkSentEventResponse();
            typedResponse.token = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.total = (Uint256) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogTokenBulkSentEventResponse> logTokenBulkSentEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("LogTokenBulkSent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogTokenBulkSentEventResponse>() {
            @Override
            public LogTokenBulkSentEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                LogTokenBulkSentEventResponse typedResponse = new LogTokenBulkSentEventResponse();
                typedResponse.token = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.total = (Uint256) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public List<LogGetTokenEventResponse> getLogGetTokenEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("LogGetToken", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<LogGetTokenEventResponse> responses = new ArrayList<LogGetTokenEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            LogGetTokenEventResponse typedResponse = new LogGetTokenEventResponse();
            typedResponse.token = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.receiver = (Address) eventValues.getNonIndexedValues().get(1);
            typedResponse.balance = (Uint256) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogGetTokenEventResponse> logGetTokenEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("LogGetToken", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogGetTokenEventResponse>() {
            @Override
            public LogGetTokenEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                LogGetTokenEventResponse typedResponse = new LogGetTokenEventResponse();
                typedResponse.token = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.receiver = (Address) eventValues.getNonIndexedValues().get(1);
                typedResponse.balance = (Uint256) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public RemoteCall<Address> receiverAddress() {
        Function function = new Function("receiverAddress", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> drop(Address _tokenAddress, DynamicArray<Address> _to, Uint256 _value, BigInteger weiValue) {
        Function function = new Function(
                "drop", 
                Arrays.<Type>asList(_tokenAddress, _to, _value), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> setVIPFee(Uint256 _fee) {
        Function function = new Function(
                "setVIPFee", 
                Arrays.<Type>asList(_fee), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> bulksendToken(Address _tokenAddress, DynamicArray<Address> _to, DynamicArray<Uint256> _value, BigInteger weiValue) {
        Function function = new Function(
                "bulksendToken", 
                Arrays.<Type>asList(_tokenAddress, _to, _value), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> bulkSendETHWithSameValue(DynamicArray<Address> _to, Uint256 _value, BigInteger weiValue) {
        Function function = new Function(
                "bulkSendETHWithSameValue", 
                Arrays.<Type>asList(_to, _value), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<Address> getReceiverAddress() {
        Function function = new Function("getReceiverAddress", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> bulksend(DynamicArray<Address> _to, DynamicArray<Uint256> _value, BigInteger weiValue) {
        Function function = new Function(
                "bulksend", 
                Arrays.<Type>asList(_to, _value), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> bulkSendCoinWithDifferentValue(Address _tokenAddress, DynamicArray<Address> _to, DynamicArray<Uint256> _value, BigInteger weiValue) {
        Function function = new Function(
                "bulkSendCoinWithDifferentValue", 
                Arrays.<Type>asList(_tokenAddress, _to, _value), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> bulkSendETHWithDifferentValue(DynamicArray<Address> _to, DynamicArray<Uint256> _value, BigInteger weiValue) {
        Function function = new Function(
                "bulkSendETHWithDifferentValue", 
                Arrays.<Type>asList(_to, _value), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> setReceiverAddress(Address _addr) {
        Function function = new Function(
                "setReceiverAddress", 
                Arrays.<Type>asList(_addr), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Address> owner() {
        Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> bulkSendCoinWithSameValue(Address _tokenAddress, DynamicArray<Address> _to, Uint256 _value, BigInteger weiValue) {
        Function function = new Function(
                "bulkSendCoinWithSameValue", 
                Arrays.<Type>asList(_tokenAddress, _to, _value), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> registerVIP(BigInteger weiValue) {
        Function function = new Function(
                "registerVIP", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<Bool> vipList(Address param0) {
        Function function = new Function("vipList", 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> addToVIPList(DynamicArray<Address> _vipList) {
        Function function = new Function(
                "addToVIPList", 
                Arrays.<Type>asList(_vipList), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Uint256> txFee() {
        Function function = new Function("txFee", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> setTxFee(Uint256 _fee) {
        Function function = new Function(
                "setTxFee", 
                Arrays.<Type>asList(_fee), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Uint256> VIPFee() {
        Function function = new Function("VIPFee", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(Address newOwner) {
        Function function = new Function(
                "transferOwnership", 
                Arrays.<Type>asList(newOwner), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Bool> isVIP(Address _addr) {
        Function function = new Function("isVIP", 
                Arrays.<Type>asList(_addr), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> removeFromVIPList(DynamicArray<Address> _vipList) {
        Function function = new Function(
                "removeFromVIPList", 
                Arrays.<Type>asList(_vipList), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getBalance(Address _tokenAddress) {
        Function function = new Function(
                "getBalance", 
                Arrays.<Type>asList(_tokenAddress), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> sendEth(DynamicArray<Address> _to, Uint256 _value, BigInteger weiValue) {
        Function function = new Function(
                "sendEth", 
                Arrays.<Type>asList(_to, _value), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public static RemoteCall<TransferTool_sol_BulkSender> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TransferTool_sol_BulkSender.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<TransferTool_sol_BulkSender> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TransferTool_sol_BulkSender.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static TransferTool_sol_BulkSender load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TransferTool_sol_BulkSender(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static TransferTool_sol_BulkSender load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TransferTool_sol_BulkSender(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class LogTokenBulkSentEventResponse {
        public Address token;

        public Uint256 total;
    }

    public static class LogGetTokenEventResponse {
        public Address token;

        public Address receiver;

        public Uint256 balance;
    }
}
