package com.leonardosilva.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoUsuario){
        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView resultado = findViewById(R.id.textView3);
        int numero = new Random().nextInt(3);

        String opcaoes[] = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcaoes[numero];

        switch (opcaoApp){
            case "pedra" :
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if((opcaoApp=="tesoura" && opcaoUsuario=="papel") ||
                (opcaoApp=="pedra" && opcaoUsuario=="tesoura") ||
                (opcaoApp=="papel" && opcaoUsuario=="pedra")){ //App ganha
            resultado.setText("Você perdeu");

        }else if((opcaoApp=="papel" && opcaoUsuario=="tesoura") ||
                (opcaoApp=="tesoura" && opcaoUsuario=="pedra") ||
                (opcaoApp=="pedra" && opcaoUsuario=="papel")){ //Usuario ganha
            resultado.setText("Você ganhou");

        }else{
            resultado.setText("Empatamos");
        }

    }
}
