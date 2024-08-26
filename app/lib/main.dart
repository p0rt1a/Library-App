// import 'package:app/services/web_socket_service.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  int _selectedIndex = 0;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        body: const [
          Center(
            child: Text("Home page works!"),
          ),
          Center(
            child: Text("Add page works!"),
          ),
          Center(
            child: Text("Profile page works!"),
          )
        ][_selectedIndex],
        bottomNavigationBar: BottomNavigationBar(
          items: const [
            BottomNavigationBarItem(icon: Icon(Icons.home), label: "Home"),
            BottomNavigationBarItem(icon: Icon(Icons.add_circle), label: "Paylaş"),
            BottomNavigationBarItem(icon: Icon(Icons.person), label: "Profil")
          ],
          currentIndex: _selectedIndex,
          onTap: (val) {
            setState(() {
              _selectedIndex = val;
            });
          },
        ),
      ),
    );
  }
}

// WebSocket usage:

// class MyApp extends StatelessWidget {
//   @override
//   Widget build(BuildContext context) {
//     return MaterialApp(
//       title: 'Flutter WebSocket Demo',
//       home: MyHomePage(),
//     );
//   }
// }

// class MyHomePage extends StatefulWidget {
//   @override
//   _MyHomePageState createState() => _MyHomePageState();
// }

// class _MyHomePageState extends State<MyHomePage> {
//   final TextEditingController _controller = TextEditingController();
//   late WebSocketService _webSocketService;
//   final String _webSocketUrl = 'ws://10.0.2.2:8080/ws';

//   @override
//   void initState() {
//     super.initState();
//     _webSocketService = WebSocketService(_webSocketUrl);
//   }

//   @override
//   void dispose() {
//     _webSocketService.close();
//     super.dispose();
//   }

//   void _sendMessage() {
//     final message = _controller.text;
//     _webSocketService.sendMessage(message);
//     _controller.clear();
//   }

//   @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//       appBar: AppBar(
//         title: Text('Flutter WebSocket Demo'),
//       ),
//       body: Column(
//         children: <Widget>[
//           Expanded(
//             child: StreamBuilder<String>(
//               stream: _webSocketService.messages,
//               builder: (context, snapshot) {
//                 return ListView(
//                   children: [
//                     if (snapshot.hasData)
//                       ListTile(title: Text('Server: ${snapshot.data}')),
//                   ],
//                 );
//               },
//             ),
//           ),
//           Padding(
//             padding: const EdgeInsets.all(16.0),
//             child: Row(
//               children: <Widget>[
//                 Expanded(
//                   child: TextField(
//                     controller: _controller,
//                     decoration: InputDecoration(
//                       labelText: 'Enter message',
//                     ),
//                   ),
//                 ),
//                 IconButton(
//                   icon: Icon(Icons.send),
//                   onPressed: _sendMessage,
//                 ),
//               ],
//             ),
//           ),
//         ],
//       ),
//     );
//   }
// }
