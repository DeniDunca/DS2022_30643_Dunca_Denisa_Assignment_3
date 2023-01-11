package ro.tuc.ds2020.services.implementation;


import grpc.address.Message;
import grpc.address.MessageRequest;
import grpc.address.MessageResponse;
import grpc.address.MessageServiceGrpc;
import io.grpc.stub.StreamObserver;

public class ChatServiceImpl extends MessageServiceGrpc.MessageServiceImplBase {
    @Override
    public void message(MessageRequest request, StreamObserver<MessageResponse> responseObserver) {

        // we get the greeting object from the request (as defined in the proto file)
        Message message = request.getMessage();
        String result = "Hello " + message.getUser() + message.getText();

        // build our response where the type should be GreetResponse
        MessageResponse response = MessageResponse.newBuilder()
                .setResult(result)
                .build();

        responseObserver.onNext(response);// send the response
        responseObserver.onCompleted();// complete the execution
    }
    @Override
    public StreamObserver<Message> chat(final StreamObserver<Message> responseObserver) {
        return new StreamObserver<Message>() {
            @Override
            public void onNext(Message value) {
                // Handle incoming message
            }

            @Override
            public void onError(Throwable t) {
                // Handle stream error
            }

            @Override
            public void onCompleted() {
                // Handle stream completion
            }
        };
    }
}