package br.com.strixteam.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.strixteam.R;
import br.com.strixteam.model.Pessoa;
import br.com.strixteam.model.PessoaBO;

public class MainActivity extends AppCompatActivity {

    private Button btnFechar;

    private EditText editNome;
    private EditText editIdade;
    private TextView tvResultado;
    private ImageView ivResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // INICIALIZA OS COMPONENTES E ATRIBUI OS VALORES DA VIEW NO CONTROLLER
        initialize();
        btnFecharListener();
    }

    private void initialize() {
        editNome = findViewById(R.id.editNome);
        editIdade = findViewById(R.id.editIdade);
        tvResultado = findViewById(R.id.tvResultado);
        btnFechar = findViewById(R.id.btnFechar);
        ivResultado = findViewById(R.id.ivResultado);
    }

    public void btnFecharListener() {

        // NORMAL
        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicou em Verificar Usando on Click Listener", Toast.LENGTH_LONG).show();
                MainActivity.this.finish(); // fecha tudo
            }
        });


//        // LAMBDA
//        btnFechar.setOnClickListener((View v) -> {
//            Toast.makeText(this, "Clicou em Fechar Usando Click Listener", Toast.LENGTH_LONG).show();
//        });

    }

    public void verificarAction(View view) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(editNome.getText().toString());
        pessoa.setIdade(editIdade.getText().toString());

        if (!PessoaBO.validarNome(pessoa.getNome())) {
            Toast.makeText(this, R.string.erro_nome, Toast.LENGTH_SHORT).show();
            editNome.setError(getString(R.string.erro_nome));
        } else if (!PessoaBO.validarIdade(pessoa.getIdade())) {
            Toast.makeText(this, R.string.erro_idade, Toast.LENGTH_SHORT).show();
            editIdade.setError(getString(R.string.erro_idade));
        } else {

            tvResultado.setText("Olá " + pessoa.getNome() + ", você possui " + pessoa.getIdade() + " ano(s)");

            if (PessoaBO.verificarMaioridadeIdade(pessoa.getIdade())) {
                ivResultado.setImageResource(R.drawable.maior_idade);
            } else {
                ivResultado.setImageResource(R.drawable.menor_idade);
            }

        }


        Toast.makeText(this, "Clicou em Verificar", Toast.LENGTH_SHORT).show();
    }

}
