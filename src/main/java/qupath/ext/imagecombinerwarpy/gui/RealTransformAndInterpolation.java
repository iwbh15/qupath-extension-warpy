/*********************************
 * This file is part of ImageCombinerWarpy ...
 * 
 * .. a QuPath extension based on the QuPath 'Interactive Image Alignment' tool
 *  
 * The ImageCombinerWarpy is thought as an experimental� tool.
 * 
 * It is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Peter Haub (@phaub), Oct 2021
 * 
 *********************************/


package qupath.ext.imagecombinerwarpy.gui;

import net.imglib2.realtransform.RealTransform;

public class RealTransformAndInterpolation {

	transient public static final int[] interpolationsModes = InterpolationModes.getOrdinalNumbers();
	transient public static final String[] interpolationsModeNames = InterpolationModes.getInterpolationTypeName();
	
	private int interpolation = 0;
	
	private RealTransform transform;
	
	public RealTransformAndInterpolation() {

	}
	
	public RealTransformAndInterpolation(RealTransformAndInterpolation transformInterpolateSequence) {
		int interpolation = transformInterpolateSequence.getInterpolation();
		if (isValidInterpolation(interpolation))
			this.interpolation = interpolation;
		this.transform = transformInterpolateSequence.getTransform();
	}

	public RealTransformAndInterpolation(RealTransform transform, int interpolation) {
		if (isValidInterpolation(interpolation))
			this.interpolation = interpolation;

		this.transform = transform;
	}

	public RealTransform getTransform() {
		return transform;
	}
	
	public void setTransform(RealTransform transform) {
		this.transform = transform;
	}
	
	public int getInterpolation() {
		return interpolation;
	}

	public String getInterpolationName() {
		return interpolationsModeNames[interpolation];
	}
	
	public void setInterpolation(int interpolation) {
		this.interpolation = interpolation;
	}

	private boolean isValidInterpolation(int interpolation) {
		for (int i=0; i<interpolationsModes.length; i++) {
			if (interpolationsModes[i] == interpolation)
				return true;
		}
		return false;
	}
}