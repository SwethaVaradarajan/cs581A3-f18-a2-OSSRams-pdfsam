package org.pdfsam.ui.io;


import java.io.File;
import javafx.stage.Window;

public abstract class Type {
	public abstract File showDialog(File selected, Window ownerWindow,
			RememberingLatestFileChooserWrapper rememberingLatestFileChooserWrapper);
}