import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class ResponseDecoderForGetPeers extends ReplayingDecoder<GetPeersSpec> {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> list) throws Exception {
        int tmp  = in.readInt();
        System.out.println("here");
        System.out.println(in);
    }
}
