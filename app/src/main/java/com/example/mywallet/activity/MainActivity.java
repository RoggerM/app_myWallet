package com.example.mywallet.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mywallet.R;
import com.example.mywallet.activity.CadastroActivity;
import com.example.mywallet.activity.LoginActivity;
import com.example.mywallet.config.ConfiguracaoFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

public class MainActivity extends IntroActivity {

    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        setButtonBackVisible(false);
        setButtonNextVisible(false);

        addSlide(new SimpleSlide.Builder()
                .title("Organize suas contas de onde estiver")
                .description("Simples, fácil de usar e grátis")
                .image(R.drawable.um)
                .background(android.R.color.white)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title("Saiba para onde está indo seu dinheiro")
                .description("Categorizando seus lançamentos e vendo o destino do cada centavo")
                .image(R.drawable.dois)
                .background(android.R.color.white)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title("Nunca mais esqueça de pagar uma conta")
                .description("Receba alertas quando quiser")
                .image(R.drawable.tres)
                .background(android.R.color.white)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title("Tudo organizado no celular ou computador")
                .description("")
                .image(R.drawable.quatro)
                .background(android.R.color.white)
                .build());

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_layout)
                .canGoForward(false)
                .build()
        );


    }


    @Override
    protected void onStart() {
        super.onStart();
        verificarUsuarioLogado();
    }

    public void btEntrar(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void btCadastrar(View view) {
        startActivity(new Intent(this, CadastroActivity.class));
    }

    public void verificarUsuarioLogado() {
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        //autenticacao.signOut();
        if (autenticacao.getCurrentUser() != null) {
            abrirTelaPrincipal();
            finish();
        }
    }

    public void abrirTelaPrincipal() {
        startActivity(new Intent(this, PrincipalActivity.class));
    }


}
