package alejandro.sudoku;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class Sudoku extends Activity implements OnClickListener {

	private static final String TAG = "Sudoku";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sudoku);

		// Event listeners
		View aboutButton = findViewById(R.id.btnAbout);
		aboutButton.setOnClickListener(this);

		View newGameButton = findViewById(R.id.btnNewGame);
		newGameButton.setOnClickListener(this);

		View continueGameButton = findViewById(R.id.btnContinueGame);
		continueGameButton.setOnClickListener(this);

		View exitButton = findViewById(R.id.btnExit);
		exitButton.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.settings:
			startActivity(new Intent(this, Prefs.class));
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnAbout:
			Intent intent = new Intent(this, About.class);
			startActivity(intent);
			break;
		case R.id.btnExit:
			finish();
			break;
		case R.id.btnNewGame:
			openNewGameDialog();
			break;
		default:
			break;
		}
	}

	private void openNewGameDialog() {
		new AlertDialog.Builder(this)
				.setTitle(R.string.new_game_title)
				.setItems(R.array.difficulty,
						new DialogInterface.OnClickListener() {
							public void onClick(
									DialogInterface dialoginterface, int i) {
								startGame(i);
							}
						}).show();
	}

	private void startGame(int i) {
		Log.d(TAG, "Clicked on" + i);
	}

}
