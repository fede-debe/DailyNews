#!/usr/bin/env bash
set -euo pipefail

IN="assets/showcase"
OUT="assets/showcase"

# Tunables (adjust if size is too big/small)
MOBILE_W=800       # Android/iOS width
DESKTOP_W=1200     # Desktop/Web width
FPS=15             # 12–15 is good for README
DUR=8              # seconds; trim to keep files small ("" to keep full)
START=0            # start offset seconds (e.g., 2 to skip first 2s)
QWEBP=70           # 60–75 -> smaller to bigger; quality for WebP
GIF_LOSSY=40       # 20–60 -> smaller to bigger; lossy level for gifsicle

convert_one () {
  local name="$1" width="$2"
  local ss=(); local t=()
  [[ "$START" != "" ]] && ss=(-ss "$START")
  [[ "$DUR"   != "" ]] && t=(-t "$DUR")

  # WebP (primary)
  ffmpeg -y "${ss[@]}" "${t[@]}" -i "$IN/$name.mp4" \
    -vf "fps=${FPS},scale='min(${width},iw)':'-2':flags=lanczos" \
    -c:v libwebp -q:v "${QWEBP}" -preset picture -loop 0 -an -vsync 0 \
    "$OUT/$name.webp"

  # GIF (fallback) — palette pipeline then compress with gifsicle
  ffmpeg -y "${ss[@]}" "${t[@]}" -i "$IN/$name.mp4" \
    -vf "fps=${FPS},scale='min(${width},iw)':'-2':flags=lanczos,split[s0][s1];[s0]palettegen=stats_mode=single[p];[s1][p]paletteuse=dither=bayer:bayer_scale=5" \
    -loop 0 "$OUT/$name.gif"

  gifsicle -O3 --lossy="${GIF_LOSSY}" -o "$OUT/$name.gif" "$OUT/$name.gif"
}

convert_one android ${MOBILE_W}
convert_one ios     ${MOBILE_W}
convert_one desktop ${DESKTOP_W}
convert_one web     ${DESKTOP_W}

echo "✅ Created: $OUT/*.webp and $OUT/*.gif"
