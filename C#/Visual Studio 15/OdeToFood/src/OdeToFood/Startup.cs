using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Logging;
using OdeToFood.Services;
using System.IO;

namespace OdeToFood
{
    public class Startup
    {
        public Startup()
        {
            var builder = new ConfigurationBuilder()
                .SetBasePath(Directory.GetCurrentDirectory())
                .AddJsonFile("appsettings.json");

            Configuration = builder.Build();
                
        }

        public IConfigurationRoot Configuration { get; set; }

        // This method gets called by the runtime. Use this method to add services to the container.
        // For more information on how to configure your application, visit http://go.microsoft.com/fwlink/?LinkID=398940
        // I need to identify my own services if I am manually inserting services.
        public void ConfigureServices(IServiceCollection services)
        {
            // Transient --> create new instance of this object everytime it is called.  Singleton --> re use single instance of IGreeter.

           services.AddSingleton(provider => Configuration);
           services.AddSingleton<IGreeter, Greeter>();    // this is important to instantiate the greeter class into configuration.
            
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(
            IApplicationBuilder app, 
            IHostingEnvironment env, 
            ILoggerFactory loggerFactory,
            IGreeter greeter
            )
        {
            loggerFactory.AddConsole();

            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            
            app.Run(async (context) =>
            {

                var greet = greeter.GetGreeting();

                await context.Response.WriteAsync(greet);

                greet = Configuration["greeting"];

                await context.Response.WriteAsync(greet);

          //      greet = greeter.GetGreeting2();

          //      await context.Response.WriteAsync(greet);
            });
        }
    }
}
