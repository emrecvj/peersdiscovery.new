import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Random;

public class ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx)
            throws Exception {
//        Random rand = new Random();
//        HandShake msg = new HandShake();
//        msg.setApplicationName("wavesW");
//        int[] tmp = {1, 4, 7};
//        msg.setApplicationVersion(tmp);
//        int base = 1000;
//        int nonce = (rand.nextInt(base) + base) * rand.nextInt(base) + rand.nextInt(base);
//        msg.setNodeName("node-"+nonce);
//        msg.setNodeNonce(nonce);
//
//        ChannelFuture future = ctx.writeAndFlush(msg);

//        GetPeersSpec getPeers = new GetPeersSpec();
//
//        future = ctx.writeAndFlush(getPeers);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        System.out.println(msg);
//        ctx.close();
    }
}
