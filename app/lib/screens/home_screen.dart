import 'package:flutter/material.dart';
import 'package:web_socket_channel/io.dart';
import 'package:web_socket_channel/web_socket_channel.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  WebSocketChannel channel = IOWebSocketChannel.connect("wss://ws://localhost:8080/gs-guide-websocket/topic/greetings");
  WebSocketChannel messageChannel = IOWebSocketChannel.connect("wss://ws://localhost:8080/gs-guide-websocket/hello");

  void sendData() {
    messageChannel.sink.add("mesaj");
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        children: [
          StreamBuilder(stream: channel.stream, builder: (context, snapshot) => Padding(padding: const EdgeInsets.all(8), child: Text(snapshot.hasData ? "${snapshot.data}" : "no data"),)),
          ElevatedButton(onPressed: sendData, child: const Text("send"))
        ],
      ),
    );
  }
}