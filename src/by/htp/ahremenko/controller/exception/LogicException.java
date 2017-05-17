package by.htp.ahremenko.controller.exception;

import by.htp.ahremenko.service.exception.ServiceException;

public class LogicException extends ServiceException {
		private static final long serialVersionUID = 1L;
		
		public LogicException () {
			super();
		}
		
		public LogicException (String msg) {
			super(msg);
		}

		public LogicException (Exception e) {
			super(e);
		}
		
		public LogicException (String msg, Exception e) {
			super( msg, e);
		}
}

