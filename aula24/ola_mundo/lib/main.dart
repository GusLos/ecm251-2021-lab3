import 'package:flutter/material.dart';

//Quando acabar  : flutter Clean Project (arquivar o projeto)
//Quando retornar: flutter Get Packages  (baixa tudo de novo)

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.deepOrange,
      ),
      home: MinhaPagina(),
    );
  }
}

class MinhaPagina extends StatelessWidget {
  const MinhaPagina({ Key? key }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Minha página web com flutter"),
      ),
      body: Column(
        children: [
          Text("Você assistiu Demon Slayer?"),
          Image.network("https://static.wikia.nocookie.net/mario/images/7/75/Mario.png/revision/latest?cb=20100929161731&path-prefix=pt-br"),
        ],
      )
    );
  }
}