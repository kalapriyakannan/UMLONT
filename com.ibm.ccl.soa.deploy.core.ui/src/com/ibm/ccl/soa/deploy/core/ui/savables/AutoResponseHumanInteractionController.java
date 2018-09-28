package com.ibm.ccl.soa.deploy.core.ui.savables;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.infrastructure.emf.IHumanInteractionController;

/**
 * <p>
 * Implementation of the IHumanInteractionController that auto responds with the boolean value
 * passed into the constructor on creation.
 * </p>
 * 
 * @author Tim Pouyer <tpouyer@us.ibm.com>
 * @since 7.0
 * 
 */
public class AutoResponseHumanInteractionController implements IHumanInteractionController {

	final boolean response;

	/**
	 * <p>
	 * Construct a new instance of the class with the indicated response value.
	 * </p>
	 * 
	 * @param response
	 *           the response value that should be returned when the requestDirection(IStatus) method
	 *           is called.
	 */
	public AutoResponseHumanInteractionController(boolean response) {
		this.response = response;
	}

	/**
	 * {@inheritDoc}
	 */
	public Response declareError(IStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Response declareInformation(IStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Response declareWarning(IStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <p>
	 * Returns the value passed in during construction of the class.
	 * </p>
	 * 
	 * @param status
	 */
	public Response requestDirection(IStatus status) {
		return new IHumanInteractionController.Response() {

			public Boolean shouldProceed() {
				return response;
			}

		};
	}

}
