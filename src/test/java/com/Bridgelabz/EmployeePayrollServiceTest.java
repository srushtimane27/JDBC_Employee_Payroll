package com.Bridgelabz;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.Bridgelabz.EmployeePayrollService.IOService.DB_IO;
import static com.Bridgelabz.EmployeePayrollService.IOService.FILE_IO;

public class EmployeePayrollServiceTest {

    @Test
    public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries() {
        EmployeePayrollData[] arrayOfEmps = {
                new EmployePayrollData(id: 1, name:"Bill", salary: 1000000),
                new EmployePayrollData(id: 2, name:"Terisa", salary: 3000000),
                new EmployePayrollData(id: 1, name:"Charlie", salary: 3000000),
        };
        EmployeePayrollService employeePayrollService;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
        employeePayrollService.writeEmployeePayrollData(FILE_IO);
        employeePayrollService.printData(FILE_IO);
        long entries = employeePayrollService.countEntries(FILE_IO);
        Assert.assertEquals(3,entries);
    }
}
