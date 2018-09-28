package com.ibm.ccl.soa.deploy.core.ui.savables;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;

public class ArtifactMovedEvent extends ArtifactEvent {

	private final Map<IFile, IFile> movedArtifacts = new HashMap<IFile, IFile>();

	public ArtifactMovedEvent(int event, Map<IFile, IFile> oldNewFileMap) {
		super(event, oldNewFileMap.keySet().toArray(new IFile[oldNewFileMap.keySet().size()]));
		movedArtifacts.putAll(oldNewFileMap);
	}

	public IFile getOldFileLocation(IFile newFileLocation) {
		return movedArtifacts.get(newFileLocation);
	}
}
