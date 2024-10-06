import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Open Browser Example',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatelessWidget {
  // Function to open a browser using url_launcher
  Future<void> _launchURL() async {
    const url = 'https://flutter.dev';  // Replace with the URL you want to open
    if (await canLaunch(url)) {
      // For mobile and web, use launchUrl with Uri.parse
      await launchUrl(Uri.parse(url), mode: LaunchMode.externalApplication);
    } else {
      throw 'Could not launch $url';
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Open Browser Example'),
      ),
      body: Center(
        child: ElevatedButton(
          onPressed: _launchURL,
          child: Text('Open Browser'),
        ),
      ),
    );
  }
}
