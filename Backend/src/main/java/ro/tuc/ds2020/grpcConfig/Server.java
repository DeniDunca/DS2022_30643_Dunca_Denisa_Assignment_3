package ro.tuc.ds2020.grpcConfig;

import io.grpc.ServerBuilder;
import ro.tuc.ds2020.services.implementation.ChatServiceImpl;


public class Server {
    public static void main(String[] args) throws Exception{
        final int PORT = 9090;
        io.grpc.Server server = ServerBuilder.forPort(PORT).addService(new ChatServiceImpl()).build();
        server.start();
        System.out.println("Server started");
        server.awaitTermination();
    }
}
