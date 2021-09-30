package com.yj.code;

import com.yj.code.contract.MultiSigV4_sol_MultiSig;
import okhttp3.OkHttpClient;
import org.bouncycastle.util.encoders.Hex;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Sign;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;


public class MultiSigT {

    public static String signMessageByte32() {

        try {
            Address address = new Address("0x37c311B3c536223E74927935D684fA7b182EDFBB");
            MultiSigV4_sol_MultiSig multiSigV4 = new MultiSigV4_sol_MultiSig("0x66Bb803e103039B0aF79F21C218c2D17ed52487a",
                    Web3j.build(new HttpService("http://127.0.0.1:7545", createOkHttpClient(), false)),
                    Credentials.create("d9b5ffed5d785544e1d37ff578314010bb3eb789f9b09ac7df70926267d8be85"), Contract.GAS_PRICE, Contract.GAS_LIMIT);
            byte[] bb = multiSigV4.generateMessageToSignWith(address, new Uint256(2)).send().getValue();
            Bytes32 aa = new Bytes32(bb);

            System.out.println("aaaa"+ Hex.toHexString(bb));
//            return Hex.toHexString(bb);
            return Hex.toHexString(bb);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String message = signMessageByte32();
        ECKeyPair k0 = ECKeyPair.create(new BigInteger("d9b5ffed5d785544e1d37ff578314010bb3eb789f9b09ac7df70926267d8be85", 16));
        Credentials k1 = Credentials.create(k0);
        Sign.SignatureData resultSign = Sign.signMessage(message.getBytes(),k0);
        System.out.println("R:::"+Hex.toHexString(resultSign.getR()));
        System.out.println("S:::"+Hex.toHexString(resultSign.getS()));
        System.out.println("V:::"+Hex.toHexString(new byte[]{resultSign.getV()}));
    }

    public void signVRS() {

    }

    public static OkHttpClient createOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.writeTimeout((30 * 1000), TimeUnit.SECONDS)
                .connectTimeout((30 * 1000), TimeUnit.SECONDS);
        return builder.build();
    }
}
