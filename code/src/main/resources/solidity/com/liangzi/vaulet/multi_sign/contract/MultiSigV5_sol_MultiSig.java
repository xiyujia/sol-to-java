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
public class MultiSigV5_sol_MultiSig extends Contract {
    private static final String BINARY = "608060405260006003553480156200001657600080fd5b5060405162001e6b38038062001e6b83398101806040528101908080518201929190602001805190602001909291905050506000825182600982111580156200005f5750818111155b80156200006d575060018110155b15156200007957600080fd5b600092505b8451831015620001a657600080600087868151811015156200009c57fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020541180620001325750600073ffffffffffffffffffffffffffffffffffffffff1685848151811015156200011057fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff16145b156200013d57600080fd5b4360008087868151811015156200015057fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190555082806001019350506200007e565b8460019080519060200190620001be929190620001d1565b50836002819055505050505050620002a6565b8280548282559060005260206000209081019282156200024d579160200282015b828111156200024c5782518260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555091602001919060010190620001f2565b5b5090506200025c919062000260565b5090565b620002a391905b808211156200029f57600081816101000a81549073ffffffffffffffffffffffffffffffffffffffff02191690555060010162000267565b5090565b90565b611bb580620002b66000396000f3006080604052600436106100c5576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063011736721461013c57806302fb0c5e146101f157806312065fe0146101fb5780631398a5f6146102265780635f43e63f146102515780636ad688261461027c57806385b2566a146102d3578063a0e67e2b14610368578063b7d5e564146103d4578063c6a2a9f114610481578063c90c0356146104ac578063d74f8edd14610535578063f3acb25814610560575b600034111561013a577f5af8184bef8e4b45eb9f6ed7734d04da38ced226495548f46e0c8ff8d7d9a5243334604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390a15b005b34801561014857600080fd5b506101ef600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019092919080359060200190820180359060200191909192939192939080359060200190820180359060200191909192939192939080359060200190820180359060200191909192939192939050505061058b565b005b6101f9610927565b005b34801561020757600080fd5b50610210610a22565b6040518082815260200191505060405180910390f35b34801561023257600080fd5b5061023b610a41565b6040518082815260200191505060405180910390f35b34801561025d57600080fd5b50610266610a4b565b6040518082815260200191505060405180910390f35b34801561028857600080fd5b506102bd600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610a52565b6040518082815260200191505060405180910390f35b3480156102df57600080fd5b50610366600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803590602001908201803590602001919091929391929390803590602001908201803590602001919091929391929390803590602001908201803590602001919091929391929390505050610a9a565b005b34801561037457600080fd5b5061037d610db1565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156103c05780820151818401526020810190506103a5565b505050509050019250505060405180910390f35b3480156103e057600080fd5b5061047f600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803590602001908201803590602001919091929391929390803590602001908201803590602001919091929391929390803590602001908201803590602001919091929391929390803590602001908201803590602001919091929391929390505050610e3f565b005b34801561048d57600080fd5b506104966110ba565b6040518082815260200191505060405180910390f35b3480156104b857600080fd5b50610517600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291905050506110c4565b60405180826000191660001916815260200191505060405180910390f35b34801561054157600080fd5b5061054a611342565b6040518082815260200191505060405180910390f35b34801561056c57600080fd5b50610575611347565b6040518082815260200191505060405180910390f35b3073ffffffffffffffffffffffffffffffffffffffff168973ffffffffffffffffffffffffffffffffffffffff161415151561062f576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601d8152602001807f4e6f7420616c6c6f772073656e64696e6720746f20796f757273656c6600000081525060200191505060405180910390fd5b6000871115156106a7576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4572633230207370656e642076616c756520696e76616c69640000000000000081525060200191505060405180910390fd5b610742888a8989898080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505088888080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505087878080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505061142d565b15156107b6576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260128152602001807f696e76616c6964207369676e617475726573000000000000000000000000000081525060200191505060405180910390fd5b6001600354016003819055508773ffffffffffffffffffffffffffffffffffffffff1663a9059cbb8a896040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050600060405180830381600087803b15801561086557600080fd5b505af1158015610879573d6000803e3d6000fd5b505050507f3d1915a2cdcecdfffc5eb2a7994c069bad5d4aa96aca85667dedbe60bb80491c888a89604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828152602001935050505060405180910390a1505050505050505050565b60008060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020541115156109dd576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252600c8152602001807f4e6f7420616e206f776e6572000000000000000000000000000000000000000081525060200191505060405180910390fd5b436000803373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550565b60003073ffffffffffffffffffffffffffffffffffffffff1631905090565b6000600254905090565b622dc6c081565b60008060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b3073ffffffffffffffffffffffffffffffffffffffff168873ffffffffffffffffffffffffffffffffffffffff1614151515610b3e576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601d8152602001807f4e6f7420616c6c6f772073656e64696e6720746f20796f757273656c6600000081525060200191505060405180910390fd5b863073ffffffffffffffffffffffffffffffffffffffff163110158015610b655750600087115b1515610bd9576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601e8152602001807f62616c616e6365206f72207370656e642076616c756520696e76616c6964000081525060200191505060405180910390fd5b610c756000898989898080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505088888080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505087878080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505061142d565b1515610ce9576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260128152602001807f696e76616c6964207369676e617475726573000000000000000000000000000081525060200191505060405180910390fd5b6001600354016003819055508773ffffffffffffffffffffffffffffffffffffffff166108fc889081150290604051600060405180830381858888f19350505050158015610d3b573d6000803e3d6000fd5b507fd3eec71143c45f28685b24760ea218d476917aa0ac0392a55e5304cef40bd2b68888604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390a15050505050505050565b60606001805480602002602001604051908101604052809291908181526020018280548015610e3557602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019060010190808311610deb575b5050505050905090565b3073ffffffffffffffffffffffffffffffffffffffff168a73ffffffffffffffffffffffffffffffffffffffff1614151515610ee3576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601d8152602001807f4e6f7420616c6c6f772073656e64696e6720746f20796f757273656c6600000081525060200191505060405180910390fd5b610f7f60098b8b8b8b808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050508a8a8080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505089898080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505061142d565b1515610ff3576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260128152602001807f696e76616c6964207369676e617475726573000000000000000000000000000081525060200191505060405180910390fd5b6001600354016003819055508973ffffffffffffffffffffffffffffffffffffffff168983836040518083838082843782019150509250505060006040518083038185875af192505050156110ae577f62ee6f1a2424e70e5cff9d61a0d928aa101e198f192d726c651f1bdad1cd40d98a8a604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390a15b50505050505050505050565b6000600354905090565b600080606030868686600354604051602001808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c01000000000000000000000000028152601401838152602001828152602001955050505050506040516020818303038152906040526040518082805190602001908083835b6020831015156111f157805182526020820191506020810190506020830392506111cc565b6001836020036101000a038019825116818451168082178552505050505050905001915050604051809103902091506040805190810160405280601c81526020017f19457468657265756d205369676e6564204d6573736167653a0a333200000000815250905080826040516020018083805190602001908083835b602083101515611292578051825260208201915060208101905060208303925061126d565b6001836020036101000a0380198251168184511680821785525050505050509050018260001916600019168152602001925050506040516020818303038152906040526040518082805190602001908083835b60208310151561130a57805182526020820191506020810190506020830392506112e5565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020925050509392505050565b600981565b6000806000809150600090505b6001805490508110156113fc5743622dc6c060008060018581548110151561137857fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054011015156113ef5781806001019250505b8080600101915050611354565b60025482101515611411576002549250611428565b60018210151561142357819250611428565b600192505b505090565b600080606060008551875114151561144457600080fd5b8451865114151561145457600080fd5b60018054905087511115151561146957600080fd5b611471611347565b87511015151561148057600080fd5b61148b8a8a8a6116e8565b925086516040519080825280602002602001820160405280156114bd5781602001602082028038833980820191505090505b509150600090505b86518110156115ee57600183601b89848151811015156114e157fe5b906020019060200201510188848151811015156114fa57fe5b90602001906020020151888581518110151561151257fe5b90602001906020020151604051600081526020016040526040518085600019166000191681526020018460ff1660ff1681526020018360001916600019168152602001826000191660001916815260200194505050505060206040516020810390808403906000865af115801561158d573d6000803e3d6000fd5b5050506020604051035182828151811015156115a557fe5b9060200190602002019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff168152505080806001019150506114c5565b6115f78261181c565b151561160257600080fd5b61160b8261194b565b611613611347565b8751101515156116d7576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260508152602001807f416374697665206f776e6572732075706461746564206166746572207468652081526020017f63616c6c2c20706c656173652063616c6c206163746976652829206265666f7281526020017f652063616c6c696e67207370656e642e0000000000000000000000000000000081525060600191505060405180910390fd5b600193505050509695505050505050565b60008060606116f8868686611a24565b91506040805190810160405280601c81526020017f19457468657265756d205369676e6564204d6573736167653a0a333200000000815250905080826040516020018083805190602001908083835b60208310151561176c5780518252602082019150602081019050602083039250611747565b6001836020036101000a0380198251168184511680821785525050505050509050018260001916600019168152602001925050506040516020818303038152906040526040518082805190602001908083835b6020831015156117e457805182526020820191506020810190506020830392506117bf565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020925050509392505050565b6000806000600180549050845111156118385760009250611944565b600091505b835182101561193f576000806000868581518110151561185957fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205414156118ad5760009250611944565b600090505b818110156119325783818151811015156118c857fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff1684838151811015156118f657fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff1614156119255760009250611944565b80806001019150506118b2565b818060010192505061183d565b600192505b5050919050565b60008090505b8151811015611a20576000806000848481518110151561196d57fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020541115611a13574360008084848151811015156119ca57fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055505b8080600101915050611951565b5050565b60008030858585600354604051602001808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c01000000000000000000000000028152601401838152602001828152602001955050505050506040516020818303038152906040526040518082805190602001908083835b602083101515611b4f5780518252602082019150602081019050602083039250611b2a565b6001836020036101000a038019825116818451168082178552505050505050905001915050604051809103902090508091505093925050505600a165627a7a72305820ddd027cb685f32eaa0ff6e2509c6f525ea3ab9485ca259c631bfb9c978cb61a40029";

    protected MultiSigV5_sol_MultiSig(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MultiSigV5_sol_MultiSig(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
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

    public RemoteCall<TransactionReceipt> active(BigInteger weiValue) {
        Function function = new Function(
                "active", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
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

    public RemoteCall<Uint256> MAX_INACTIVE_BLOCKNUMBER() {
        Function function = new Function("MAX_INACTIVE_BLOCKNUMBER", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Uint256> getOwnerBlock(Address addr) {
        Function function = new Function("getOwnerBlock", 
                Arrays.<Type>asList(addr), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
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

    public RemoteCall<Bytes32> generateMessageToSignWith(Address erc20Contract, Address destination, Uint256 value) {
        Function function = new Function("generateMessageToSignWith", 
                Arrays.<Type>asList(erc20Contract, destination, value), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Uint256> MAX_OWNER_COUNT() {
        Function function = new Function("MAX_OWNER_COUNT", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Uint256> getRequiredWithoutInactive() {
        Function function = new Function("getRequiredWithoutInactive", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public static RemoteCall<MultiSigV5_sol_MultiSig> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, DynamicArray<Address> _owners, Uint256 _required) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_owners, _required));
        return deployRemoteCall(MultiSigV5_sol_MultiSig.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<MultiSigV5_sol_MultiSig> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, DynamicArray<Address> _owners, Uint256 _required) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_owners, _required));
        return deployRemoteCall(MultiSigV5_sol_MultiSig.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static MultiSigV5_sol_MultiSig load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MultiSigV5_sol_MultiSig(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static MultiSigV5_sol_MultiSig load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MultiSigV5_sol_MultiSig(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
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
