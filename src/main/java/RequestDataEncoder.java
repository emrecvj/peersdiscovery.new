import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class RequestDataEncoder extends MessageToByteEncoder<HandShake> {
    private final Charset charset = StandardCharsets.UTF_8;
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, HandShake handShake, ByteBuf out) throws Exception {
        byte[] applicationNameBytes = handShake.getApplicationName().getBytes(charset);
        out.writeByte(applicationNameBytes.length);
        out.writeBytes(applicationNameBytes);

        out.writeInt(handShake.getApplicationVersion()[0]);
        out.writeInt(handShake.getApplicationVersion()[1]);
        out.writeInt(handShake.getApplicationVersion()[2]);

        byte[] nodeNameBytes = handShake.getNodeName().getBytes(charset);
        out.writeByte(nodeNameBytes.length);
        out.writeBytes(nodeNameBytes);

        out.writeLong(handShake.getNodeNonce());


        out.writeInt(0);
//        InetSocketAddress addr = new InetSocketAddress("144.91.76.41",6861);
//        out.writeInt(addr.getAddress().getAddress().length + Integer.BYTES);
//        out.writeBytes(addr.getAddress().getAddress());
//        out.writeInt(addr.getPort());

        out.writeLong(System.currentTimeMillis() / 1000);
    }
}
