using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(DemoWebForms.Startup))]
namespace DemoWebForms
{
    public partial class Startup {
        public void Configuration(IAppBuilder app) {
            ConfigureAuth(app);
        }
    }
}
