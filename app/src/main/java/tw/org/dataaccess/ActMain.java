package tw.org.dataaccess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActMain extends AppCompatActivity {

    private View.OnClickListener btnShared_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ActMain.this, ActShared.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener btnFile_Click;
    private View.OnClickListener btnSqlite_Click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitialComponent();
    }

    private void InitialComponent() {
        btnShared = findViewById(R.id.btnShared);
        btnShared.setOnClickListener(btnShared_Click);
        btnFile = findViewById(R.id.btnFile);
        btnFile.setOnClickListener(btnFile_Click);
        btnSqlite = findViewById(R.id.btnSqlite);
        btnSqlite.setOnClickListener(btnSqlite_Click);
    }
    Button btnShared;
    Button btnFile;
    Button btnSqlite;
}
