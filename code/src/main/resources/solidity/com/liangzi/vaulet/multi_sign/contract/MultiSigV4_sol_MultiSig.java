package com.liangzi.vaulet.multi_sign.contract;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicBytes;
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
public class MultiSigV4_sol_MultiSig extends Contract {
    private static final String BINARY = "608060405260006003553480156200001657600080fd5b50604051620019ae380380620019ae83398101806040528101908080518201929190602001805190602001909291905050506000825182600982111580156200005f5750818111155b80156200006d575060018110155b15156200007957600080fd5b600092505b8451831015620001c45760008086858151811015156200009a57fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16806200013c5750600073ffffffffffffffffffffffffffffffffffffffff1685848151811015156200011a57fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff16145b156200014757600080fd5b600160008087868151811015156200015b57fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555082806001019350506200007e565b8460019080519060200190620001dc929190620001ef565b50836002819055505050505050620002c4565b8280548282559060005260206000209081019282156200026b579160200282015b828111156200026a5782518260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055509160200191906001019062000210565b5b5090506200027a91906200027e565b5090565b620002c191905b80821115620002bd57600081816101000a81549073ffffffffffffffffffffffffffffffffffffffff02191690555060010162000285565b5090565b90565b6116da80620002d46000396000f300608060405260043610610099576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063011736721461011057806312065fe0146101c55780631398a5f6146101f05780637b843b6c1461021b57806385b2566a14610284578063a0e67e2b14610319578063b7d5e56414610385578063c6a2a9f114610432578063d74f8edd1461045d575b600034111561010e577f5af8184bef8e4b45eb9f6ed7734d04da38ced226495548f46e0c8ff8d7d9a5243334604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390a15b005b34801561011c57600080fd5b506101c3600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803590602001908201803590602001919091929391929390803590602001908201803590602001919091929391929390803590602001908201803590602001919091929391929390505050610488565b005b3480156101d157600080fd5b506101da610824565b6040518082815260200191505060405180910390f35b3480156101fc57600080fd5b50610205610843565b6040518082815260200191505060405180910390f35b34801561022757600080fd5b50610266600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019092919050505061084d565b60405180826000191660001916815260200191505060405180910390f35b34801561029057600080fd5b50610317600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803590602001908201803590602001919091929391929390803590602001908201803590602001919091929391929390803590602001908201803590602001919091929391929390505050610acb565b005b34801561032557600080fd5b5061032e610de2565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b83811015610371578082015181840152602081019050610356565b505050509050019250505060405180910390f35b34801561039157600080fd5b50610430600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803590602001908201803590602001919091929391929390803590602001908201803590602001919091929391929390803590602001908201803590602001919091929391929390803590602001908201803590602001919091929391929390505050610e70565b005b34801561043e57600080fd5b506104476110eb565b6040518082815260200191505060405180910390f35b34801561046957600080fd5b506104726110f5565b6040518082815260200191505060405180910390f35b3073ffffffffffffffffffffffffffffffffffffffff168973ffffffffffffffffffffffffffffffffffffffff161415151561052c576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601d8152602001807f4e6f7420616c6c6f772073656e64696e6720746f20796f757273656c6600000081525060200191505060405180910390fd5b6000871115156105a4576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4572633230207370656e642076616c756520696e76616c69640000000000000081525060200191505060405180910390fd5b61063f888a898989808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050508888808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050508787808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050506110fa565b15156106b3576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260128152602001807f696e76616c6964207369676e617475726573000000000000000000000000000081525060200191505060405180910390fd5b6001600354016003819055508773ffffffffffffffffffffffffffffffffffffffff1663a9059cbb8a896040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050600060405180830381600087803b15801561076257600080fd5b505af1158015610776573d6000803e3d6000fd5b505050507f3d1915a2cdcecdfffc5eb2a7994c069bad5d4aa96aca85667dedbe60bb80491c888a89604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828152602001935050505060405180910390a1505050505050505050565b60003073ffffffffffffffffffffffffffffffffffffffff1631905090565b6000600254905090565b60008060603060008686600354604051602001808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c01000000000000000000000000028152601401838152602001828152602001955050505050506040516020818303038152906040526040518082805190602001908083835b60208310151561097b5780518252602082019150602081019050602083039250610956565b6001836020036101000a038019825116818451168082178552505050505050905001915050604051809103902091506040805190810160405280601c81526020017f19457468657265756d205369676e6564204d6573736167653a0a333200000000815250905080826040516020018083805190602001908083835b602083101515610a1c57805182526020820191506020810190506020830392506109f7565b6001836020036101000a0380198251168184511680821785525050505050509050018260001916600019168152602001925050506040516020818303038152906040526040518082805190602001908083835b602083101515610a945780518252602082019150602081019050602083039250610a6f565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390209250505092915050565b3073ffffffffffffffffffffffffffffffffffffffff168873ffffffffffffffffffffffffffffffffffffffff1614151515610b6f576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601d8152602001807f4e6f7420616c6c6f772073656e64696e6720746f20796f757273656c6600000081525060200191505060405180910390fd5b863073ffffffffffffffffffffffffffffffffffffffff163110158015610b965750600087115b1515610c0a576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601e8152602001807f62616c616e6365206f72207370656e642076616c756520696e76616c6964000081525060200191505060405180910390fd5b610ca6600089898989808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050508888808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050508787808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050506110fa565b1515610d1a576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260128152602001807f696e76616c6964207369676e617475726573000000000000000000000000000081525060200191505060405180910390fd5b6001600354016003819055508773ffffffffffffffffffffffffffffffffffffffff166108fc889081150290604051600060405180830381858888f19350505050158015610d6c573d6000803e3d6000fd5b507fd3eec71143c45f28685b24760ea218d476917aa0ac0392a55e5304cef40bd2b68888604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390a15050505050505050565b60606001805480602002602001604051908101604052809291908181526020018280548015610e6657602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019060010190808311610e1c575b5050505050905090565b3073ffffffffffffffffffffffffffffffffffffffff168a73ffffffffffffffffffffffffffffffffffffffff1614151515610f14576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601d8152602001807f4e6f7420616c6c6f772073656e64696e6720746f20796f757273656c6600000081525060200191505060405180910390fd5b610fb060098b8b8b8b808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050508a8a808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050508989808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050506110fa565b1515611024576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260128152602001807f696e76616c6964207369676e617475726573000000000000000000000000000081525060200191505060405180910390fd5b6001600354016003819055508973ffffffffffffffffffffffffffffffffffffffff168983836040518083838082843782019150509250505060006040518083038185875af192505050156110df577f62ee6f1a2424e70e5cff9d61a0d928aa101e198f192d726c651f1bdad1cd40d98a8a604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390a15b50505050505050505050565b6000600354905090565b600981565b600080606060008551875114151561111157600080fd5b8451865114151561112157600080fd5b60018054905087511115151561113657600080fd5b60025487511015151561114857600080fd5b6111538a8a8a6112db565b925086516040519080825280602002602001820160405280156111855781602001602082028038833980820191505090505b509150600090505b86518110156112b657600183601b89848151811015156111a957fe5b906020019060200201510188848151811015156111c257fe5b9060200190602002015188858151811015156111da57fe5b90602001906020020151604051600081526020016040526040518085600019166000191681526020018460ff1660ff1681526020018360001916600019168152602001826000191660001916815260200194505050505060206040516020810390808403906000865af1158015611255573d6000803e3d6000fd5b50505060206040510351828281518110151561126d57fe5b9060200190602002019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff1681525050808060010191505061118d565b6112bf8261140f565b15156112ca57600080fd5b600193505050509695505050505050565b60008060606112eb868686611549565b91506040805190810160405280601c81526020017f19457468657265756d205369676e6564204d6573736167653a0a333200000000815250905080826040516020018083805190602001908083835b60208310151561135f578051825260208201915060208101905060208303925061133a565b6001836020036101000a0380198251168184511680821785525050505050509050018260001916600019168152602001925050506040516020818303038152906040526040518082805190602001908083835b6020831015156113d757805182526020820191506020810190506020830392506113b2565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020925050509392505050565b60008060006001805490508451111561142b5760009250611542565b600091505b835182101561153d57600080858481518110151561144a57fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff1615156114ab5760009250611542565b600090505b818110156115305783818151811015156114c657fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff1684838151811015156114f457fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff1614156115235760009250611542565b80806001019150506114b0565b8180600101925050611430565b600192505b5050919050565b60008030858585600354604051602001808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c01000000000000000000000000028152601401838152602001828152602001955050505050506040516020818303038152906040526040518082805190602001908083835b602083101515611674578051825260208201915060208101905060208303925061164f565b6001836020036101000a038019825116818451168082178552505050505050905001915050604051809103902090508091505093925050505600a165627a7a7230582033b8b8770949346502ccd7a905d27078f6ea7f5e1d947d15b2db65a2626b3aca0029";

    protected MultiSigV4_sol_MultiSig(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MultiSigV4_sol_MultiSig(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<FundedEventResponse> getFundedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Funded", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<FundedEventResponse> responses = new ArrayList<FundedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            FundedEventResponse typedResponse = new FundedEventResponse();
            typedResponse.from = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.value = (Uint256) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<FundedEventResponse> fundedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Funded", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, FundedEventResponse>() {
            @Override
            public FundedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                FundedEventResponse typedResponse = new FundedEventResponse();
                typedResponse.from = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.value = (Uint256) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public List<SpentEventResponse> getSpentEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Spent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<SpentEventResponse> responses = new ArrayList<SpentEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            SpentEventResponse typedResponse = new SpentEventResponse();
            typedResponse.to = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.transfer = (Uint256) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<SpentEventResponse> spentEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Spent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, SpentEventResponse>() {
            @Override
            public SpentEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                SpentEventResponse typedResponse = new SpentEventResponse();
                typedResponse.to = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.transfer = (Uint256) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public List<SpentERC20EventResponse> getSpentERC20Events(TransactionReceipt transactionReceipt) {
        final Event event = new Event("SpentERC20", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<SpentERC20EventResponse> responses = new ArrayList<SpentERC20EventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            SpentERC20EventResponse typedResponse = new SpentERC20EventResponse();
            typedResponse.erc20contract = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.to = (Address) eventValues.getNonIndexedValues().get(1);
            typedResponse.transfer = (Uint256) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<SpentERC20EventResponse> spentERC20EventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("SpentERC20", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, SpentERC20EventResponse>() {
            @Override
            public SpentERC20EventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                SpentERC20EventResponse typedResponse = new SpentERC20EventResponse();
                typedResponse.erc20contract = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.to = (Address) eventValues.getNonIndexedValues().get(1);
                typedResponse.transfer = (Uint256) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public List<SpentAnyEventResponse> getSpentAnyEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("SpentAny", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<SpentAnyEventResponse> responses = new ArrayList<SpentAnyEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            SpentAnyEventResponse typedResponse = new SpentAnyEventResponse();
            typedResponse.to = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.transfer = (Uint256) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<SpentAnyEventResponse> spentAnyEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("SpentAny", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, SpentAnyEventResponse>() {
            @Override
            public SpentAnyEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                SpentAnyEventResponse typedResponse = new SpentAnyEventResponse();
                typedResponse.to = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.transfer = (Uint256) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public RemoteCall<TransactionReceipt> spendERC20(Address destination, Address erc20contract, Uint256 value, DynamicArray<Uint8> vs, DynamicArray<Bytes32> rs, DynamicArray<Bytes32> ss) {
        Function function = new Function(
                "spendERC20", 
                Arrays.<Type>asList(destination, erc20contract, value, vs, rs, ss), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Uint256> getBalance() {
        Function function = new Function("getBalance", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Uint256> getRequired() {
        Function function = new Function("getRequired", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Bytes32> generateMessageToSignWith(Address destination, Uint256 value) {
        Function function = new Function("generateMessageToSignWith", 
                Arrays.<Type>asList(destination, value), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> spend(Address destination, Uint256 value, DynamicArray<Uint8> vs, DynamicArray<Bytes32> rs, DynamicArray<Bytes32> ss) {
        Function function = new Function(
                "spend", 
                Arrays.<Type>asList(destination, value, vs, rs, ss), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<DynamicArray<Address>> getOwners() {
        Function function = new Function("getOwners", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> spendAny(Address destination, Uint256 value, DynamicArray<Uint8> vs, DynamicArray<Bytes32> rs, DynamicArray<Bytes32> ss, DynamicBytes data) {
        Function function = new Function(
                "spendAny", 
                Arrays.<Type>asList(destination, value, vs, rs, ss, data), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Uint256> getSpendNonce() {
        Function function = new Function("getSpendNonce", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Uint256> MAX_OWNER_COUNT() {
        Function function = new Function("MAX_OWNER_COUNT", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public static RemoteCall<MultiSigV4_sol_MultiSig> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, DynamicArray<Address> _owners, Uint256 _required) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_owners, _required));
        return deployRemoteCall(MultiSigV4_sol_MultiSig.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<MultiSigV4_sol_MultiSig> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, DynamicArray<Address> _owners, Uint256 _required) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_owners, _required));
        return deployRemoteCall(MultiSigV4_sol_MultiSig.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static MultiSigV4_sol_MultiSig load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MultiSigV4_sol_MultiSig(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static MultiSigV4_sol_MultiSig load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MultiSigV4_sol_MultiSig(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class FundedEventResponse {
        public Address from;

        public Uint256 value;
    }

    public static class SpentEventResponse {
        public Address to;

        public Uint256 transfer;
    }

    public static class SpentERC20EventResponse {
        public Address erc20contract;

        public Address to;

        public Uint256 transfer;
    }

    public static class SpentAnyEventResponse {
        public Address to;

        public Uint256 transfer;
    }
}
