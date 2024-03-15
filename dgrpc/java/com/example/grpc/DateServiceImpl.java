package java.com.example.grpc;

import com.example.proto.DateServiceGrpc;
import com.example.proto.DateResponse;
import com.example.proto.EmptyRequest;
import com.google.protobuf.util.Timestamps;
import io.grpc.stub.StreamObserver;

public class DateServiceImpl extends DateServiceGrpc.DateServiceImplBase {
    @Override
    public void getCurrentDate(EmptyRequest request, StreamObserver<DateResponse> responseObserver) {
        DateResponse response = DateResponse.newBuilder()
                .setDate(
                        Timestamps.toString(
                                Timestamps.fromMillis(System.currentTimeMillis())))
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}