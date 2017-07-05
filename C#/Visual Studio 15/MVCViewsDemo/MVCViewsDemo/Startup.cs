using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(MVCViewsDemo.Startup))]
namespace MVCViewsDemo
{
    public partial class Startup {
        public void Configuration(IAppBuilder app) {
            ConfigureAuth(app);
        }
    }
}
