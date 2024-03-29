// <copyright file="MemoryCalculatorTestsTest.cs">Copyright ©  2017</copyright>
using System;
using DemoTestApplication.Tests;
using Microsoft.Pex.Framework;
using Microsoft.Pex.Framework.Validation;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace DemoTestApplication.Tests.Tests
{
    /// <summary>This class contains parameterized unit tests for MemoryCalculatorTests</summary>
    [PexClass(typeof(MemoryCalculatorTests))]
    [PexAllowedExceptionFromTypeUnderTest(typeof(InvalidOperationException))]
    [PexAllowedExceptionFromTypeUnderTest(typeof(ArgumentException), AcceptExceptionSubtypes = true)]
    [TestClass]
    public partial class MemoryCalculatorTestsTest
    {
        /// <summary>Test stub for ShouldAdd()</summary>
        [PexMethod]
        public void ShouldAddTest([PexAssumeUnderTest]MemoryCalculatorTests target)
        {
            target.ShouldAdd();
            // TODO: add assertions to method MemoryCalculatorTestsTest.ShouldAddTest(MemoryCalculatorTests)
        }

        [PexMethod]
        public void ShouldSubractTest([PexAssumeUnderTest]MemoryCalculatorTests target)
        {
            target.ShouldSubtract();
            // TODO: add assertions to method MemoryCalculatorTestsTest.ShouldAddTest(MemoryCalculatorTests)
        }
    }
}
