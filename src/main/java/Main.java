import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        String host = "78.46.163.61";
        int port = 6868;


        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new RequestDataEncoder());
                            p.addLast(new ResponseDataDecoder());
                            p.addLast(new RequestDataEncoderForGetPeers());
                            p.addLast(new ResponseDecoderForGetPeers());
                            p.addLast(new ClientHandler());

                        }
                    });

            // Start the client.
            ChannelFuture f = b.connect(host, port).sync();
            Random rand = new Random();
            HandShake handshake = new HandShake();
            handshake.setApplicationName("wavesW");
            int[] tmp = {1, 4, 7};
            handshake.setApplicationVersion(tmp);
            int base = 1000;
            int nonce = (rand.nextInt(base) + base) * rand.nextInt(base) + rand.nextInt(base);
            handshake.setNodeName("node-" + nonce);
            handshake.setNodeNonce(nonce);
            Channel channel = f.sync().channel();

            channel.writeAndFlush(handshake);

            GetPeersSpec getPeers = new GetPeersSpec();

            channel.writeAndFlush(getPeers);
            f.channel().closeFuture().sync();
        } finally {
            // Shut down the event loop to terminate all threads.
            group.shutdownGracefully();
        }
    }
}
