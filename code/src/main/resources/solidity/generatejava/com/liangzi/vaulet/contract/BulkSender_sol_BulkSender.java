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
import org.web3j.abi.datatypes.Utf8String;
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
public class BulkSender_sol_BulkSender extends Contract {
    private static final String BINARY = "6080604052662386f26fc10000600255670de0b6b3a7640000600355336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550612fa58061006a6000396000f30060806040526004361062000163576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806305a063c7146200016857806316fed3e214620002715780631d833aae14620002cb57806337e0fed914620003505780633d06242a14620003d55780634a311f4d14620004055780634c3b891214620004c3578063531ebce5146200052857806355f6e87a146200058257806362b632f4146200062057806375c6b74a14620006de5780638279c7db146200077c5780638da5cb5b14620007c2578063986078fe146200081c5780639c1f613314620008a1578063aa168b4714620008ad578063c8813ffd146200090b578063cf8204611462000974578063f05d16f714620009a2578063f0a0a29914620009d2578063f2fde38b1462000a00578063f4201c3c1462000a46578063f48d11af1462000aa4578063f8b2cb4f1462000b0d578063feaf653d1462000b53575b600080fd5b3480156200017557600080fd5b506200022f600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803560ff1690602001909291908035906020019092919050505062000bb8565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156200027e57600080fd5b506200028962000d81565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6200034e600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001908201803590602001908080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505091929192908035906020019092919050505062000da7565b005b620003d3600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001908201803590602001908080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505091929192908035906020019092919050505062000db9565b005b348015620003e257600080fd5b50620004036004803603810190808035906020019092919050505062000dcb565b005b620004c1600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001908201803590602001908080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505091929192908035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919291929050505062000e31565b005b62000526600480360381019080803590602001908201803590602001908080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505091929192908035906020019092919050505062000e43565b005b3480156200053557600080fd5b506200054062000e53565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6200061e600480360381019080803590602001908201803590602001908080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505091929192908035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919291929050505062000eff565b005b620006dc600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001908201803590602001908080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505091929192908035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919291929050505062000f0f565b005b6200077a600480360381019080803590602001908201803590602001908080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505091929192908035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919291929050505062000f21565b005b3480156200078957600080fd5b50620007c0600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505062000f31565b005b348015620007cf57600080fd5b50620007da6200100e565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6200089f600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001908201803590602001908080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505091929192908035906020019092919050505062001033565b005b620008ab62001045565b005b348015620008ba57600080fd5b50620008f1600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505062001101565b604051808215151515815260200191505060405180910390f35b3480156200091857600080fd5b50620009726004803603810190808035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919291929050505062001121565b005b3480156200098157600080fd5b506200098c62001210565b6040518082815260200191505060405180910390f35b348015620009af57600080fd5b50620009d06004803603810190808035906020019092919050505062001216565b005b348015620009df57600080fd5b50620009ea6200127c565b6040518082815260200191505060405180910390f35b34801562000a0d57600080fd5b5062000a44600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505062001282565b005b34801562000a5357600080fd5b5062000a8a600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505062001359565b604051808215151515815260200191505060405180910390f35b34801562000ab157600080fd5b5062000b0b6004803603810190808035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919291929050505062001407565b005b34801562000b1a57600080fd5b5062000b51600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050620014f6565b005b62000bb6600480360381019080803590602001908201803590602001908080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505091929192908035906020019092919050505062001838565b005b600080858585853362000bca62002084565b8080602001806020018660ff1660ff1681526020018581526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838103835288818151815260200191508051906020019080838360005b8381101562000c5157808201518184015260208101905062000c34565b50505050905090810190601f16801562000c7f5780820380516001836020036101000a031916815260200191505b50838103825287818151815260200191508051906020019080838360005b8381101562000cba57808201518184015260208101905062000c9d565b50505050905090810190601f16801562000ce85780820380516001836020036101000a031916815260200191505b50975050505050505050604051809103906000f08015801562000d0f573d6000803e3d6000fd5b5090507f395045c2e65bece0119fe1f96eadc5e7655c57538d45fcfb2a8f26af5e97069d81604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390a180915050949350505050565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b62000db483838362001848565b505050565b62000dc683838362001848565b505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151562000e2757600080fd5b8060038190555050565b62000e3e83838362001a63565b505050565b62000e4f828262001c94565b5050565b60008073ffffffffffffffffffffffffffffffffffffffff16600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141562000ed6576000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905062000efc565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690505b90565b62000f0b828262001e35565b5050565b62000f1c83838362001a63565b505050565b62000f2d828262001e35565b5050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151562000f8d57600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415151562000fca57600080fd5b80600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6200104083838362001848565b505050565b600060035434101515156200105957600080fd5b6200106362000e53565b90508073ffffffffffffffffffffffffffffffffffffffff166108fc349081150290604051600060405180830381858888f193505050501515620010a657600080fd5b6001600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b60046020528060005260406000206000915054906101000a900460ff1681565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156200117f57600080fd5b600090505b81518110156200120c576001600460008484815181101515620011a357fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff021916908315150217905550808060010191505062001184565b5050565b60025481565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156200127257600080fd5b8060028190555050565b60035481565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515620012de57600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415156200135657806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b50565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff161480620014005750600460008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff165b9050919050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156200146557600080fd5b600090505b8151811015620014f25760006004600084848151811015156200148957fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555080806001019150506200146a565b5050565b60008060008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156200155757600080fd5b6200156162000e53565b9250600073ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff161415620015f7578273ffffffffffffffffffffffffffffffffffffffff166108fc3073ffffffffffffffffffffffffffffffffffffffff16319081150290604051600060405180830381858888f193505050501515620015f157600080fd5b62001832565b8391508173ffffffffffffffffffffffffffffffffffffffff166370a08231306040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b1580156200169657600080fd5b505af1158015620016ab573d6000803e3d6000fd5b505050506040513d6020811015620016c257600080fd5b810190808051906020019092919050505090508173ffffffffffffffffffffffffffffffffffffffff1663a9059cbb84836040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050600060405180830381600087803b1580156200177957600080fd5b505af11580156200178e573d6000803e3d6000fd5b505050507fc9076fc68f7c8242d2eeb2e0c02b8cafae31bb4fcbe2b89ef1f27846ac6facaf848483604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828152602001935050505060405180910390a15b50505050565b62001844828262001c94565b5050565b6000806000806000803495506200185f3362001359565b94508415156200187c5760025486101515156200187b57600080fd5b5b60ff8851111515156200188e57600080fd5b339350620018bc87620018ad60018b516200200c90919063ffffffff16565b6200202990919063ffffffff16565b9250889150600090505b87518160ff161015620019ed578173ffffffffffffffffffffffffffffffffffffffff166323b872dd858a8460ff168151811015156200190257fe5b906020019060200201518a6040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050600060405180830381600087803b158015620019c657600080fd5b505af1158015620019db573d6000803e3d6000fd5b505050508080600101915050620018c6565b7fe4e3577249108daaa0a07e6d9aabc5fef8e89ec09da3f9dccfe7ef215e4efc128984604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390a1505050505050505050565b600080600080600034945062001a793362001359565b935083151562001a9657600254851015151562001a9557600080fd5b5b8551875114151562001aa757600080fd5b60ff87511115151562001ab957600080fd5b85600081518110151562001ac957fe5b906020019060200201519250879150600090505b86518160ff16101562001c1f578173ffffffffffffffffffffffffffffffffffffffff166323b872dd33898460ff1681518110151562001b1957fe5b90602001906020020151898560ff1681518110151562001b3557fe5b906020019060200201516040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050600060405180830381600087803b15801562001bf857600080fd5b505af115801562001c0d573d6000803e3d6000fd5b50505050808060010191505062001add565b7fe4e3577249108daaa0a07e6d9aabc5fef8e89ec09da3f9dccfe7ef215e4efc128884604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390a15050505050505050565b60008060008062001cc58562001cb6600189516200200c90919063ffffffff16565b6200202990919063ffffffff16565b935034925062001cd53362001359565b9150811562001cf45783831015151562001cee57600080fd5b62001d1b565b62001d0b600254856200206290919063ffffffff16565b831015151562001d1a57600080fd5b5b60ff86511115151562001d2d57600080fd5b600090505b85518160ff16101562001dc05762001d5485846200200c90919063ffffffff16565b9250858160ff1681518110151562001d6857fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff166108fc869081150290604051600060405180830381858888f19350505050151562001db257600080fd5b808060010191505062001d32565b7fe4e3577249108daaa0a07e6d9aabc5fef8e89ec09da3f9dccfe7ef215e4efc1261beef34604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390a1505050505050565b60008060008084600081518110151562001e4b57fe5b90602001906020020151935034925062001e653362001359565b9150811562001e845783831015151562001e7e57600080fd5b62001eab565b62001e9b600254856200206290919063ffffffff16565b831015151562001eaa57600080fd5b5b8451865114151562001ebc57600080fd5b60ff86511115151562001ece57600080fd5b600090505b85518160ff16101562001f975762001f10858260ff1681518110151562001ef657fe5b90602001906020020151846200200c90919063ffffffff16565b9250858160ff1681518110151562001f2457fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff166108fc868360ff1681518110151562001f5957fe5b906020019060200201519081150290604051600060405180830381858888f19350505050151562001f8957600080fd5b808060010191505062001ed3565b7fe4e3577249108daaa0a07e6d9aabc5fef8e89ec09da3f9dccfe7ef215e4efc1261beef34604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390a1505050505050565b60008282111515156200201e57600080fd5b818303905092915050565b600080828402905060008414806200204c57508284828115156200204957fe5b04145b15156200205857600080fd5b8091505092915050565b60008082840190508381101515156200207a57600080fd5b8091505092915050565b604051610ee48062002096833901905600608060405234801561001057600080fd5b50604051610ee4380380610ee48339810180604052810190808051820192919060200180518201929190602001805190602001909291908051906020019092919080519060200190929190505050806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555082600360006101000a81548160ff021916908360ff160217905550600360009054906101000a900460ff1660ff16600a0a820260048190555084600190805190602001906100ed929190610176565b508360029080519060200190610104929190610176565b50600454600560008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550505050505061021b565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106101b757805160ff19168380011785556101e5565b828001600101855582156101e5579182015b828111156101e45782518255916020019190600101906101c9565b5b5090506101f291906101f6565b5090565b61021891905b808211156102145760008160009055506001016101fc565b5090565b90565b610cba8061022a6000396000f3006080604052600436106100a4576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806306fdde03146100a9578063095ea7b31461013957806318160ddd1461018657806323b872dd146101b1578063313ce5671461021e57806370a082311461024f5780638da5cb5b146102a657806395d89b41146102fd578063a9059cbb1461038d578063dd62ed3e146103da575b600080fd5b3480156100b557600080fd5b506100be610451565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156100fe5780820151818401526020810190506100e3565b50505050905090810190601f16801561012b5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561014557600080fd5b50610184600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291905050506104ef565b005b34801561019257600080fd5b5061019b61066f565b6040518082815260200191505060405180910390f35b3480156101bd57600080fd5b5061021c600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610675565b005b34801561022a57600080fd5b50610233610918565b604051808260ff1660ff16815260200191505060405180910390f35b34801561025b57600080fd5b50610290600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061092b565b6040518082815260200191505060405180910390f35b3480156102b257600080fd5b506102bb610974565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561030957600080fd5b50610312610999565b6040518080602001828103825283818151815260200191508051906020019080838360005b83811015610352578082015181840152602081019050610337565b50505050905090810190601f16801561037f5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561039957600080fd5b506103d8600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610a37565b005b3480156103e657600080fd5b5061043b600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610bca565b6040518082815260200191505060405180910390f35b60018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156104e75780601f106104bc576101008083540402835291602001916104e7565b820191906000526020600020905b8154815290600101906020018083116104ca57829003601f168201915b505050505081565b600081148061057a57506000600660003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054145b151561058557600080fd5b80600660003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055508173ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925836040518082815260200191505060405180910390a35050565b60045481565b6106c781600560008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054610c5190919063ffffffff16565b600560008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190555061075c81600560008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054610c7290919063ffffffff16565b600560008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190555061082e81600660008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054610c7290919063ffffffff16565b600660008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055508173ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef836040518082815260200191505060405180910390a3505050565b600360009054906101000a900460ff1681565b6000600560008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60028054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610a2f5780601f10610a0457610100808354040283529160200191610a2f565b820191906000526020600020905b815481529060010190602001808311610a1257829003601f168201915b505050505081565b610a8981600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054610c7290919063ffffffff16565b600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550610b1e81600560008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054610c5190919063ffffffff16565b600560008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055508173ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef836040518082815260200191505060405180910390a35050565b6000600660008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054905092915050565b6000808284019050838110151515610c6857600080fd5b8091505092915050565b6000828211151515610c8357600080fd5b8183039050929150505600a165627a7a72305820a9ded6a18f22091ef6812974cf1ca64baa67d8476f381b89d41c0fa48fe3362d0029a165627a7a723058208b567ef46d95055b0812ee2d2f7f6f3b166b69eef2dcf0cd0560f2f0f85f812e0029";

    protected BulkSender_sol_BulkSender(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected BulkSender_sol_BulkSender(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
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

    public List<LogCreatedTokenEventResponse> getLogCreatedTokenEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("LogCreatedToken", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<LogCreatedTokenEventResponse> responses = new ArrayList<LogCreatedTokenEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            LogCreatedTokenEventResponse typedResponse = new LogCreatedTokenEventResponse();
            typedResponse.ERC20 = (Address) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogCreatedTokenEventResponse> logCreatedTokenEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("LogCreatedToken", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogCreatedTokenEventResponse>() {
            @Override
            public LogCreatedTokenEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                LogCreatedTokenEventResponse typedResponse = new LogCreatedTokenEventResponse();
                typedResponse.ERC20 = (Address) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public RemoteCall<TransactionReceipt> crearteRERC20Token(Utf8String _name, Utf8String _symbol, Uint8 _decimals, Uint256 _initialSupply) {
        Function function = new Function(
                "crearteRERC20Token", 
                Arrays.<Type>asList(_name, _symbol, _decimals, _initialSupply), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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

    public RemoteCall<TransactionReceipt> bulkCoinCollect(Address _tokenAddress, DynamicArray<Address> _from, Uint256 _value, BigInteger weiValue) {
        Function function = new Function(
                "bulkCoinCollect", 
                Arrays.<Type>asList(_tokenAddress, _from, _value), 
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

    public static RemoteCall<BulkSender_sol_BulkSender> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BulkSender_sol_BulkSender.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<BulkSender_sol_BulkSender> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BulkSender_sol_BulkSender.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static BulkSender_sol_BulkSender load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BulkSender_sol_BulkSender(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static BulkSender_sol_BulkSender load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BulkSender_sol_BulkSender(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
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

    public static class LogCreatedTokenEventResponse {
        public Address ERC20;
    }
}
