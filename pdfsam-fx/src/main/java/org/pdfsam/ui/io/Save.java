package org.pdfsam.ui.io;


import java.io.File;
import javafx.stage.Window;

/**
 * @see org.pdfsam.ui.io.RememberingLatestFileChooserWrapper.OpenType#SAVE
 */
public class Save extends Type {
	public File showDialog(File selected, Window ownerWindow,
			RememberingLatestFileChooserWrapper rememberingLatestFileChooserWrapper) {
		selected = rememberingLatestFileChooserWrapper.getWrapped().showSaveDialog(ownerWindow);
		return selected;
	}
}