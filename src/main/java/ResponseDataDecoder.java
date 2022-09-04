import com.google.common.base.Charsets;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.List;

public class ResponseDataDecoder extends ReplayingDecoder<HandShake> {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> list) throws Exception {
        int appNameSize = in.readByte();
        String appName = in.readSlice(appNameSize).toString(Charsets.UTF_8);
        int[] appVersion = {in.readInt(), in.readInt(), in.readInt()};
        int nodeNameSize = in.readByte();
        String nodeName = in.readSlice(nodeNameSize).toString(Charsets.UTF_8);
        long nonce = in.readLong();
        System.out.println(appName);
        int declaredAddressLength = in.readInt();
        // 0 for no declared address, 8 for ipv4 address + port, 20 for ipv6 address + port
        if (declaredAddressLength != 0 && declaredAddressLength != 8 && declaredAddressLength != 20) {
//            throw new InvalidHandshakeException(s"An invalid declared address length: $declaredAddressLength")
            System.out.println("s\"An invalid declared address length: " + declaredAddressLength);
        }
        InetSocketAddress isa;
        if (declaredAddressLength == 0) isa = null;
        else {
            byte[] addressBytes = new byte[declaredAddressLength - Integer.BYTES];
            in.readBytes(addressBytes);
            InetAddress address = InetAddress.getByAddress(addressBytes);
            int port = in.readInt();
            isa = new InetSocketAddress(address, port);
        }
        in.readLong(); // time is ignored
        HandShake h = new HandShake();
        h.setApplicationName(appName);
        h.setApplicationVersion(appVersion);
        h.setNodeName(nodeName);
        h.setNodeNonce(nonce);
        h.setIsa(isa);
        System.out.println(h);
        System.out.println(list);
    }
}
