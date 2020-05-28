package tw.org.dataaccess;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActShared extends AppCompatActivity {

    private View.OnClickListener btnSave_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences table = getSharedPreferences("T1", Activity.MODE_PRIVATE);
            SharedPreferences.Editor row = table.edit();
            row.putString("KK",lblInputText.getText().toString()).commit();

            Toast.makeText(ActShared.this,"寫入資料成功!",Toast.LENGTH_SHORT).show();

        }
    };
    private View.OnClickListener btnGet_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences table = getSharedPreferences("T1", Activity.MODE_PRIVATE);
            String data = table.getString("KK","NODATA");
            lblShowMessage.setText(data);

            Toast.makeText(ActShared.this, "讀取資料成功!", Toast.LENGTH_SHORT).show();

        }
    };
    private View.OnClickListener btnClear_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences table = getSharedPreferences("T1", Activity.MODE_PRIVATE);
            SharedPreferences.Editor row = table.edit();
            row.putString("KK",null).commit();
            lblInputText.setText(" ");
            lblShowMessage.setText(" ");

            Toast.makeText(ActShared.this, "清除資料成功!", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common);
        InitialComponent();
    }

    private void InitialComponent() {
        lblInputText = findViewById(R.id.lblInputText);
        lblShowMessage = findViewById(R.id.lblShowMessage);

        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(btnSave_Click);
        btnGet = findViewById(R.id.btnGet);
        btnGet.setOnClickListener(btnGet_Click);
        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(btnClear_Click);

    }

    EditText lblInputText;
    TextView lblShowMessage;
    Button btnSave;
    Button btnGet;
    Button btnClear;

}
