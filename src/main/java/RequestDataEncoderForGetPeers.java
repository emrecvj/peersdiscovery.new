import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.StandardCharsets;

public class RequestDataEncoderForGetPeers  extends MessageToByteEncoder<GetPeersSpec> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, GetPeersSpec getPeersSpec, ByteBuf out) throws Exception {
        out.writeInt(getPeersSpec.packetLength);
        out.writeBytes(getPeersSpec.magicBytes);
        out.writeByte(getPeersSpec.content);
        out.writeInt(getPeersSpec.payloadLength);
        out.writeBytes(getPeersSpec.payloadChecksum);
//        out.writeBytes(getPeersSpec.payload.getBytes(StandardCharsets.UTF_8));
    }
}
