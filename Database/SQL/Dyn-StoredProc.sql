/*Example of a Dynamic Stored Procedure Query Builder using sp_executesql  */

/*Below is an example of static SQL:*/


SELECT    JobTitle, Count(BusinessEntityID)
FROM      HumanResources.Employee
WHERE     Year(BirthDate) = 1970
GROUP BY  JobTitle

SELECT    JobTitle, Count(BusinessEntityID)
FROM      HumanResources.Employee
WHERE     Year(BirthDate) = 1971
GROUP BY JobTitle


/* Dynamic Query Builder using sp_executesql*/

DECLARE @birthYear int = 1970
DECLARE @statement NVARCHAR(4000)

WHILE @birthYear <= 1971
BEGIN
   SET @statement = '
        SELECT   JobTitle, Count(BusinessEntityID)
        FROM     HumanResources.Employee
        WHERE    Year(BirthDate) = ' + CAST(@birthYear as NVARCHAR) +
      ' GROUP BY JobTitle'

   EXECUTE sp_executesql @statement
   SET @birthYear = @birthYear + 1
END