import 'package:app/screens/register_screen.dart';
import 'package:flutter/material.dart';

class LoginScreen extends StatefulWidget {
  const LoginScreen({super.key});

  @override
  State<LoginScreen> createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  final TextEditingController _usernameController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();
  final _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.blue.shade50,
      appBar: AppBar(
        elevation: 12,
        foregroundColor: Colors.white,
        backgroundColor: Colors.blue,
        title: const Text("Login",),
      ),
      body: Padding(
        padding: const EdgeInsets.all(20),
        child: Center(
          child: Form(
            key: _formKey,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                TextFormField(
                  decoration: const InputDecoration(
                      fillColor: Colors.white,
                      filled: true,
                      icon: Icon(Icons.person),
                      labelText: "Username"),
                  controller: _usernameController,
                  validator: (value) {
                    if (value!.trim().isEmpty) {
                      return "Required field";
                    }
                    return null;
                  },
                ),
                const SizedBox(
                  height: 10,
                ),
                TextFormField(
                  obscureText: true,
                  decoration: const InputDecoration(
                      icon: Icon(Icons.lock),
                      filled: true,
                      fillColor: Colors.white,
                      labelText: "Password"),
                  controller: _passwordController,
                  validator: (value) {
                    if (value!.trim().isEmpty) {
                      return "Required field!";
                    }
                    return null;
                  },
                ),
                const SizedBox(
                  height: 10,
                ),
                ElevatedButton(
                    style: const ButtonStyle(
                        backgroundColor: WidgetStatePropertyAll(Colors.blue)),
                    onPressed: () {
                      if (_formKey.currentState!.validate()) {
                        try {
                          //TODO: Submit form
                          //TODO: Navigate to next page
                          _usernameController.clear();
                          _passwordController.clear();
                        } catch (ex) {
                          //TODO: Error handling
                        }
                      }
                    },
                    child: const Text(
                      "Login",
                      style: TextStyle(color: Colors.white),
                    )),
                const SizedBox(height: 20),
                GestureDetector(
                  onTap: () {
                    Navigator.of(context).push(MaterialPageRoute(
                        builder: (context) => const RegisterScreen()));
                  },
                  child: RichText(
                      text: const TextSpan(
                          text: "Don't you have an account? ",
                          style: TextStyle(color: Colors.black),
                          children: [
                        TextSpan(
                            text: "Register now.",
                            style: TextStyle(color: Colors.blue))
                      ])),
                )
              ],
            ),
          ),
        ),
      ),
    );
  }
}
