package lesson10.labs.prob1.bugreporter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lesson10.labs.prob1.classfinder.ClassFinder;

public class BugReportGenerator {
	private static final String PACKAGE_TO_SCAN = "lesson10.labs.prob1.javapackage";
	private static final String REPORT_NAME = "bug_report.txt";
	private static final String REPORTED_BY = "    reportedBy: ";
	private static final String CLASS_NAME = "    classname: ";
	private static final String DESCRIPTION = "    description: ";
	private static final String SEVERITY = "    severity: ";

	public void reportGenerator() {
		// Step 1: Find all classes in the package
		List<Class<?>> classes = ClassFinder.find(PACKAGE_TO_SCAN);
		Map<String, StringBuilder> bugReports = new HashMap<>();

		// Step 2: Process each class
		for (Class<?> cl : classes) {
			if (cl.isAnnotationPresent(BugReport.class)) {
				BugReport annotation = cl.getAnnotation(BugReport.class);

				// Extract details from annotation
				String assignedTo = annotation.assignedTo();
				String reportedBy = annotation.reportedBy();
				String description = annotation.description();
				int severity = annotation.severity();
				String className = cl.getSimpleName();

				// Format bug details
				StringBuilder bugDetails = new StringBuilder()
						.append(REPORTED_BY).append(reportedBy).append("\n")
						.append(CLASS_NAME).append(className).append("\n")
						.append(DESCRIPTION).append(description).append("\n")
						.append(SEVERITY).append(severity).append("\n\n");

				// Add bug details to the assigned developer's report
				bugReports.putIfAbsent(assignedTo, new StringBuilder());
				bugReports.get(assignedTo).append(bugDetails);
			}
		}

		// Step 3: Write the report to a file
		try (PrintWriter writer = new PrintWriter(new FileWriter(REPORT_NAME))) {
			for (Map.Entry<String, StringBuilder> entry : bugReports.entrySet()) {
				writer.println(entry.getKey());
				writer.println(entry.getValue().toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
