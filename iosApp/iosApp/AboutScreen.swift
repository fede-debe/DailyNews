//
//  AboutScreen.swift
//  iosApp
//
//  Created by Federico De Benedictis on 18/08/2025.
//

import SwiftUI

struct AboutScreen: View {
    var body: some View {
      NavigationStack {
        AboutListView()
          .navigationTitle("About Device")
      }
    }
}

#Preview {
    AboutScreen()
}
